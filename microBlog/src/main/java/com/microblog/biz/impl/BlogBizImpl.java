package com.microblog.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microblog.bean.Blog;
import com.microblog.bean.BlogModel;
import com.microblog.biz.BlogBiz;
import com.microblog.dao.BaseDao;
@Service
@Transactional(readOnly=true)
public class BlogBizImpl implements BlogBiz {
	private BaseDao baseDao;
	@Resource(name="baseDaoImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Transactional(readOnly=false)
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
				List<Blog> hh = this.baseDao.findList(Blog.class, null, "getHouse",
						off, hs.getSizePage());
				hs.setBlogs(hh);;
				return hs;
	}
	
}
