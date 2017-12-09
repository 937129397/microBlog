package com.microblog.biz.impl;

import javax.annotation.Resource;

import com.microblog.dao.BaseDao;


public abstract class BaseBiz {
	protected BaseDao baseDao;
	
	@Resource(name = "baseDaoImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
}
