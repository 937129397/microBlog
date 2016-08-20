package com.microblog.bizimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.microblog.Biz.UserBiz;
import com.microblog.bean.User;
import com.yc.utils.Encrypt;


@Service
public class UserBizImpl extends BaseBiz implements UserBiz {

	@Transactional(readOnly = false, isolation = Isolation.DEFAULT, rollbackForClassName = { "java.lang.RuntimeException" }, propagation = Propagation.REQUIRED)
	public boolean register(User user) {
		user.setPassword(Encrypt.md5(user.getPassword()));
		baseDao.save(user, "saveUser");
		return true;
	}

	@Transactional(readOnly = true, isolation = Isolation.DEFAULT, rollbackForClassName = { "java.lang.RuntimeException" }, propagation = Propagation.NOT_SUPPORTED)
	public boolean validate(User user) {
		user = (User) baseDao.find(user, "getUserByName");
		if (user != null) {
			return true;
		}
		return false;
	}

	@Transactional(readOnly = true, isolation = Isolation.DEFAULT, rollbackForClassName = { "java.lang.RuntimeException" }, propagation = Propagation.NOT_SUPPORTED)
	public User login(User user) {
		user.setPassword(Encrypt.md5(user.getPassword()));
		return (User) baseDao.find(user, "getUserByLogin");
	}
	

}
