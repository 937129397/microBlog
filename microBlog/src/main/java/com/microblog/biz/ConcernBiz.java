package com.microblog.biz;

import java.util.List;

import com.microblog.bean.Concern;

import com.microblog.bean.User;

public interface ConcernBiz {
	//添加关注
	public boolean addConcern(Concern concern);
	
	//取消关注
	public boolean delConcern(Integer id);
	
	//查询粉丝
	public List<User> getFans(User user);
	
	//查询关注
	public List<User> getConcern(User user);
	
	//查询粉丝数
	public Integer getFansCount(Concern concern);
	//根据粉丝Id查出博主ID
	public List<Integer> getBidByFid(Concern id);
	
	//查询关注数
		public Integer getConcernCount(Concern concern);

}
