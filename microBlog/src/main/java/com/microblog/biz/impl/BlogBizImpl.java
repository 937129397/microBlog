package com.microblog.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.microblog.bean.Blog;
import com.microblog.biz.BlogBiz;
import com.microblog.dao.BaseDao;

import com.microblog.web.model.BlogModel;
@Service
@Transactional(readOnly = true)
public class BlogBizImpl implements BlogBiz {
	private BaseDao baseDao;

	@Resource(name = "baseDaoImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	
	
	/**
	 * 发布微博存入数据库
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,rollbackForClassName="java.lang.RuntimeException",propagation=Propagation.REQUIRED)
	public void saveBlog(Blog blog) {
		this.baseDao.save(blog, "saveBlog");
	}

	
	
	
	//得到总的微博
	public BlogModel findAllBlog(BlogModel hs) {
		// 查询总记录数
		int count = baseDao.getCount(Blog.class, "getBlogCount");
		// 计算总页数
		int total = count % hs.getSizePage() == 0 ? count / hs.getSizePage()
				: count / hs.getSizePage() + 1;
		hs.setTotal(total);
		// 计算偏移量
		int off = (hs.getCurrPage() - 1) * hs.getSizePage();
		List<Blog> hh = this.baseDao.findList(Blog.class, null, "getBlog", off,
				hs.getSizePage());
		// 操作redis数据库 整合关系数据库
		for (Blog blog : hh) {
			Long id = blog.getId();
			//获取点赞数
			String parse = (String) this.baseDao.getKey("user:parse" + id);
			blog.setParse(parse);
			//获取转发数
			String relay=(String) this.baseDao.getKey("user:relay" + id);
			blog.setRelay(relay);
		}
		hs.setBlogs(hh);
		return hs;
	}
	
	
	//点赞
	@Override
	public String parse(Long id, int uid) {
		// 当用户没有点赞，则点赞数+1，redis中用户字段+1；点了赞，则点赞数-1，redis中用户字段-1
		if (id > 0 && uid > 0) {
			if (this.baseDao.getKey("user:id" + id + uid) == null
					|| Integer.parseInt((String) this.baseDao.getKey("user:id"
							+ id + uid)) == 0) {
				this.baseDao.incr("user:parse" + id);
				this.baseDao.incr("user:id" + id + uid);
			} else {
				this.baseDao.decr("user:parse" + id);
				this.baseDao.decr("user:id" + id + uid);
			}
			String num = (String) this.baseDao.getKey("user:parse" + id);
			return num;
		} else {
			return null;
		}

	}
	//转发
	@Override
	public String relay(Long id, int uid) {
		// 当用户没有转发，则转发数+1，redis中用户字段+1；已转发，则不允许转发
				if (id > 0 && uid > 0) {
					if (this.baseDao.getKey("user:relayid" + id + uid) == null
							|| Integer.parseInt((String) this.baseDao.getKey("user:relayid"
									+ id + uid)) == 0) {
						this.baseDao.incr("user:relay" + id);
						this.baseDao.incr("user:relayid" + id + uid);
						String num = (String) this.baseDao.getKey("user:relay" + id);
						return num;
					} else {
						return null;
					}
				} else {
					return null;
				}
	}

}
