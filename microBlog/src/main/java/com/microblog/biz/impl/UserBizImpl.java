package com.microblog.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.microblog.biz.UserBiz;
import com.microblog.bean.Groups;
import com.microblog.bean.User;


@Service
public class UserBizImpl extends BaseBiz implements UserBiz {

	@Transactional(readOnly = false, isolation = Isolation.DEFAULT, rollbackForClassName = { "java.lang.RuntimeException" }, propagation = Propagation.REQUIRED)
	public boolean register(User user) {
		//user.setPassword(Encrypt.md5(user.getPassword()));
		baseDao.save(user, "saveUser");
		return true;
	}

	@Transactional(readOnly = true, isolation = Isolation.DEFAULT, rollbackForClassName = { "java.lang.RuntimeException" }, propagation = Propagation.NOT_SUPPORTED)
	public boolean validate(User user) {
		user = (User) baseDao.find(user, "getUserByTelephone");
		if (user != null) {
			return true;
		}
		return false;
	}
	
	@Transactional(readOnly = true, isolation = Isolation.DEFAULT, rollbackForClassName = { "java.lang.RuntimeException" }, propagation = Propagation.NOT_SUPPORTED)
	public boolean validate1(User user) {
		user = (User) baseDao.find(user, "getUserByEmail");
		if (user != null) {
			return true;
		}
		return false;
	}

	@Transactional(readOnly = true, isolation = Isolation.DEFAULT, rollbackForClassName = { "java.lang.RuntimeException" }, propagation = Propagation.NOT_SUPPORTED)
	public User loginByEmail(User user) {
		//user.setPassword(Encrypt.md5(user.getPassword()));
		return (User) baseDao.find(user, "getUserByLogin1");
	}

	@Override
	public User loginByTelephone(User user) {
		return (User) baseDao.find(user, "getUserByLogin1");
	}
	
	@Transactional(readOnly = false, isolation = Isolation.DEFAULT, rollbackForClassName = { "java.lang.RuntimeException" }, propagation = Propagation.REQUIRED)
	public boolean update(User user){
		baseDao.update(user, "updateUser");;
		return true;
		
	}
	
	
	@Transactional(readOnly = true)
	public List<Groups> findUserGroups(User user) {
		Map<String ,Object> params=new HashMap<String,Object>();
		params.put("uid",user.getUid());
		return baseDao.findList(Groups.class, params, "getUserGroupsByUserID", 0, 5) ;
	}

	@Transactional(readOnly = false, isolation = Isolation.DEFAULT, rollbackForClassName = { "java.lang.RuntimeException" }, propagation = Propagation.REQUIRED)
	public boolean addUserGroups(User group) {
		baseDao.save(group, "addUserGroup");
		return true;
	}

	@Override
	public List<Integer> getUidList() {
		return baseDao.findAll(User.class,"getAllUserId");
	}


}
