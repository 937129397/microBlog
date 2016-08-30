package com.microblog.biz.impl;


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
	public boolean delConcern(Concern concern) {
		baseDao.del(Concern.class, "delConcern");
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

}
