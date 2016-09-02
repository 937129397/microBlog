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

	
	


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microblog.bean.Concern;
import com.microblog.bean.User;
import com.microblog.biz.ConcernBiz;

@Service
public class ConcernBizImpl extends BaseBiz implements ConcernBiz {

	@Transactional(readOnly = false)
	public boolean addConcern(Concern concern) {
		baseDao.save(concern, "addGroups");
		return true;
	}


	@Transactional(readOnly = false)
	public boolean delConcern(Integer id) {
		baseDao.del(Concern.class, id,"delConcern");
		return true;
	}

	@Transactional(readOnly = true)
	public List<User> getFans(User user) {
		Map<String ,Object> map=new HashMap<String,Object>();
		map.put("uid",user.getUid());
		return baseDao.findList(Concern.class, map, "getUsersFans", 0, 5);
	}

	@Transactional(readOnly = true)
	public Integer getFansCount(Concern user) {
		return (Integer) baseDao.find(user, "getUserFansCount");
	}
	@Override
	public List<Integer> getBidByFid(Concern id) {
		Map<String ,Object> params=new HashMap<String,Object>();
		params.put("f_uid", id.getF_uid());
		return (List<Integer>) baseDao.findList(Concern.class, params, "getBidByFid", 0,5);

}

	@Override
	public Integer getConcernCount(Concern concern) {
		return (Integer) baseDao.find(concern, "getUserFansCount");
	}

	@Override
	public List<User> getConcern(User user) {
		Map<String ,Object> map=new HashMap<String,Object>();
		map.put("uid",user.getUid());
		return baseDao.findList(Concern.class, map, "getUsersConcern", 0, 5);
	}
}
