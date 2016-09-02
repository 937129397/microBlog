package com.microblog.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.microblog.bean.Blog;
import com.microblog.bean.Concern;
import com.microblog.bean.User;
import com.microblog.biz.BlogBiz;
import com.microblog.dao.BaseDao;
import com.microblog.util.YcConstants;
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
	@Transactional(readOnly = false, isolation = Isolation.DEFAULT, rollbackForClassName = "java.lang.RuntimeException", propagation = Propagation.REQUIRED)
	public void saveBlog(Blog blog) {
		this.baseDao.save(blog, "saveBlog");
	}

	// 得到总的微博
	public BlogModel findAllBlog(BlogModel hs) {
		Map<String ,Object> params=new HashMap<String,Object>();
		User u=new User();
		//u.setUid(2);
		//ServletActionContext.getRequest().getSession().setAttribute(YcConstants.LOGINUSER,u);
		//登录之后才能查询所关注的好友的微博
		if( ServletActionContext.getRequest().getSession().getAttribute(YcConstants.LOGINUSER)!=null&&!"".equals( ServletActionContext.getRequest().getSession().getAttribute(YcConstants.LOGINUSER))){
			u=(User) ServletActionContext.getRequest().getSession().getAttribute(YcConstants.LOGINUSER);
			params.put("f_uid",u.getUid());
			// 查询总记录数
			int count = baseDao.getCount(Blog.class,params, "getBlogCount");
			// 计算总页数
			int total = count % hs.getSizePage() == 0 ? count / hs.getSizePage()
					: count / hs.getSizePage() + 1;
			hs.setTotal(total);
			// 计算偏移量
			int off = (hs.getCurrPage() - 1) * hs.getSizePage();
			
			List<Blog> hh = this.baseDao.findList(Concern.class, params, "getID", off,
					hs.getSizePage());
			// 操作redis数据库 整合关系数据库
			for (Blog blog : hh) {
				Long id = blog.getId();
				// 获取点赞数
				String parse = (String) this.baseDao.getKey("user:parse" + id);
				blog.setParse(parse);
				// 获取转发数
				String relay = (String) this.baseDao.getKey("user:relay" + id);
				blog.setRelay(relay);
			}
			hs.setBlogs(hh);
			return hs;
		}else{
			return null;
		}
		
	}

	// 点赞（redis）
	@Override
	public String parse(Long id, int uid) {
		// 当用户没有点赞，则点赞数+1，redis中用户字段+1；点了赞，则点赞数-1，redis中用户字段-1
		if (id > 0 && uid > 0) {
			if (this.baseDao.getKey(id + "user:id" + uid) == null
					|| Integer.parseInt((String) this.baseDao.getKey(id
							+ "user:id" + uid)) == 0) {
				this.baseDao.incr("user:parse" + id);

				this.baseDao.incr(id + "user:id" + uid);
			} else {
				this.baseDao.decr("user:parse" + id);
				this.baseDao.decr(id + "user:id" + uid);
			}
			String num = (String) this.baseDao.getKey("user:parse" + id);
			return num;
		} else {
			return null;
		}

	}

	// 转发（redis）

	@Override
	public String relay(Long id, int uid) {
		// 当用户没有转发，则转发数+1，redis中用户字段+1；已转发，则不允许转发
		if (id > 0 && uid > 0) {
			if (this.baseDao.getKey(id + "user:relayid" + uid) == null
					|| Integer.parseInt((String) this.baseDao.getKey(id
							+ "user:relayid" + uid)) == 0) {
				this.baseDao.incr("user:relay" + id);
				this.baseDao.incr(id + "user:relayid" + uid);
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
