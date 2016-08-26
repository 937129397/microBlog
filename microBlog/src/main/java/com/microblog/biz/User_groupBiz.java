package com.microblog.biz;

import com.microblog.bean.User_group;

public interface User_groupBiz {
	
	//查找用户的所有分组
	public User_group findUserGroups(Integer uid);
	
	//插入用户的自定义分组
	public boolean addUserGroups(User_group group);
}
