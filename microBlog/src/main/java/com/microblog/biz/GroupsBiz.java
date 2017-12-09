package com.microblog.biz;

import java.util.List;

import com.microblog.bean.Groups;
import com.microblog.bean.User;

public interface GroupsBiz {
	
	//自定义分组
	public boolean  addGroup(Groups group);
	
	//查找默认分组
	public List<Groups> findGroups();

	//查找用户的所有分组
	public  List<Groups> findUserGroups(User user);
}
