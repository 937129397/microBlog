package com.microblog.biz.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.microblog.bean.User_group;
import com.microblog.biz.User_groupBiz;

@Service
public class User_groupBizImpl extends BaseBiz implements User_groupBiz {

	private static final long serialVersionUID = -3221050301568225686L;

	@Transactional(readOnly = false, isolation = Isolation.DEFAULT, rollbackForClassName = { "java.lang.RuntimeException" }, propagation = Propagation.REQUIRED)
	public User_group findUserGroups(Integer uid) {
		return null;
	}

	@Override
	public boolean addUserGroups(User_group group) {
		baseDao.save(group, "addUserGroup");
		return true;
	}

}
