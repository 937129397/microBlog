package com.microblog.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microblog.bean.Concern;
import com.microblog.bean.User;
import com.microblog.biz.ConcernBiz;
import com.microblog.dao.BaseDao;

@Service
@Transactional(readOnly = true)
public class ConcernBizImpl implements ConcernBiz {
	private BaseDao baseDao;

	@Resource(name = "baseDaoImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public List<Integer> getBidByFid(Concern id) {
		Map<String ,Object> params=new HashMap<String,Object>();
		params.put("f_uid", id.getF_uid());
		return (List<Integer>) baseDao.findList(Concern.class, params, "getBidByFid", 0,5);
	}

}
