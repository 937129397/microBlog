package com.microblog.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microblog.bean.Blog;
import com.microblog.bean.Comment;
import com.microblog.bean.Concern;
import com.microblog.biz.CommentBiz;

@Service
public class CommentBizImpl extends BaseBiz implements CommentBiz {

	@Transactional(readOnly=true)
	public List<Comment> getAllComment(Blog blog) {
		Map<String ,Object> map=new HashMap<String,Object>();
		map.put("blog_id",blog.getId());
		return baseDao.findList(Concern.class, map, "getAllComment", 0, 5);
	}

	@Transactional(readOnly=false)
	public boolean addComment(Comment comment) {
		baseDao.save(comment, "addComment");
		return true;
	}

	@Transactional(readOnly=false)
	public boolean delComment(Integer id) {
		baseDao.del(Comment.class, id, "delComment");
		return false;
	}

}
