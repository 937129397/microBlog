package com.microblog.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microblog.bean.Blog;
import com.microblog.biz.BlogBiz;
import com.microblog.dao.BaseDao;
@Service
@Transactional(readOnly=true)
public class BlogBizImpl implements BlogBiz {
	private BaseDao baseDao;
	@Transactional(readOnly=false)
	public void saveBlog(Blog blog) {
		this.baseDao.save(blog, "saveBlog");
	}
	@Resource(name="baseDaoImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
}
