package com.microblog.Biz;

import com.microblog.bean.User;

public interface UserBiz {

	public boolean register(User user);

	/**
	 * 查询用户名是否已经存在
	 * @param user
	 * @return
	 */
	public boolean validate(User user);

	
	public User login(User user);

}