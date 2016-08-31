package com.microblog.biz;

import java.util.List;

import com.microblog.bean.Concern;

public interface ConcernBiz {
	//根据粉丝Id查出博主ID
	public List<Integer> getBidByFid(Concern id);
}
