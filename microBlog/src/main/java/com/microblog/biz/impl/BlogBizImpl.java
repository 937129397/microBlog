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
@Transactional(readOnly=true)
public class BlogBizImpl implements BlogBiz {
	private BaseDao baseDao;
	@Resource(name="baseDaoImpl")
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
				List<Blog> hh = this.baseDao.findList(Blog.class, null, "getBlog",
						off, hs.getSizePage());
				hs.setBlogs(hh);
				return hs;
	}
	
}
