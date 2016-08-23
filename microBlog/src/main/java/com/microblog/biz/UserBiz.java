package com.microblog.biz;

import com.microblog.bean.User;

public interface UserBiz {

	public boolean register(User user);

	/**
	 * 查询用户名是否已经存在
	 * @param user
	 * @return
	 */
	public boolean validate(User user);

	
	public User loginByEmail(User user);

	
	public User loginByTelephone(User user);
	
	public boolean update(User user);
}