package com.microblog.biz.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.microblog.bean.Groups;
import com.microblog.biz.GroupsBiz;
import com.microblog.dao.BaseDao;

@Service
public class GroupsBizImpl extends BaseBiz implements GroupsBiz {

	@Transactional(readOnly = false, isolation = Isolation.DEFAULT, rollbackForClassName = { "java.lang.RuntimeException" }, propagation = Propagation.REQUIRED)
	public boolean addGroup(Groups group) {
		baseDao.save(group, "addGroups");
		return true;
	}

	@Transactional(readOnly = false, isolation = Isolation.DEFAULT, rollbackForClassName = { "java.lang.RuntimeException" }, propagation = Propagation.NOT_SUPPORTED)
	public List<Groups> findGroups() {
		return baseDao.findAll(Groups.class, "getBaseGroups");

	}

}
