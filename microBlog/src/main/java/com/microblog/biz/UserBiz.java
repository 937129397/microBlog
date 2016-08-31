package com.microblog.biz;

import java.util.List;

import com.microblog.bean.Groups;
import com.microblog.bean.User;

public interface UserBiz {

	public boolean register(User user);

	/**
	 * 查询用户名是否已经存在
	 * @param user
	 * @return
	 */
	public boolean validate(User user);

	public boolean validate1(User user);
	
	public User loginByEmail(User user);

	
	public User loginByTelephone(User user);
	
	public boolean update(User user);
	
	//查找用户的所有分组
	public  List<Groups> findUserGroups(User user);
	
	//插入用户的自定义分组
	public boolean addUserGroups(User group);
	
	//查出所有的用户ID 建立websocket连接时使用
	public List<Integer> getUidList();
	

}