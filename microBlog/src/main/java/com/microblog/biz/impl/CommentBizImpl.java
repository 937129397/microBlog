package com.microblog.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.microblog.bean.Blog;
import com.microblog.bean.Comment;
import com.microblog.bean.Concern;
import com.microblog.biz.CommentBiz;

public class CommentBizImpl extends BaseBiz implements CommentBiz {

	@Override
	public List<Comment> getAllComment(Blog blog) {
		Map<String ,Object> map=new HashMap<String,Object>();
		map.put("blog_id",blog.getId());
		return baseDao.findList(Concern.class, map, "getAllComment", 0, 5);
	}

	@Override
	public boolean addComment(Comment comment) {
		baseDao.save(comment, "addComment");
		return true;
	}

	@Override
	public boolean delComment(Integer id) {
		baseDao.del(Comment.class, id, "delComment");
		return false;
	}

}
