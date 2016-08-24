package com.microblog.biz;

import java.util.List;

import com.microblog.bean.Groups;

public interface GroupsBiz {
	
	//自定义分组
	public boolean  addGroup(Groups group);
	
	//查找默认分组
	public List<Groups> findGroups();

}
