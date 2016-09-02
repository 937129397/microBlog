package com.microblog.web.actions;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.stereotype.Service;

import com.microblog.bean.Concern;
import com.microblog.bean.User;
import com.microblog.biz.ConcernBiz;
import com.microblog.util.YcConstants;
@Service
public class ConcernAction extends BaseAction {
	private ConcernBiz concernBiz;
	
	@Resource(name="concernBizImpl")
	public void setConcernBiz(ConcernBiz concernBiz) {
		this.concernBiz = concernBiz;
	}


	private static final long serialVersionUID = 565115697626641827L;
	
	@Action(value="concern_getFansCount")
	public void getFansCount() throws IOException{
		User user =(User)ServletActionContext.getRequest().getSession().getAttribute(YcConstants.LOGINUSER);
		Concern cc  = new Concern();
		cc.setB_uid(user.getUid());
		Integer i = concernBiz.getFansCount(cc);
		if(i==null){
			i=0;
		}
		jsonModel.setCode(1);
		jsonModel.setObj(i);
		
		super.printJson(jsonModel, ServletActionContext.getResponse());
	}

	@Action(value="concern_getConcernCount")
	public void getConcernCount() throws IOException{
		User user =(User)ServletActionContext.getRequest().getSession().getAttribute(YcConstants.LOGINUSER);
		Concern cc  = new Concern();
		cc.setF_uid(user.getUid());
		Integer i = concernBiz.getFansCount(cc);
		if(i==null){
			i=0;
		}
		jsonModel.setCode(1);
		jsonModel.setObj(i);
		
		super.printJson(jsonModel, ServletActionContext.getResponse());
	}
	
	@Action(value="concern_getFansInfo")
	public void getConcernInfo() throws IOException{
		User user =(User)ServletActionContext.getRequest().getSession().getAttribute(YcConstants.LOGINUSER);
		Concern cc  = new Concern();
		cc.setB_uid(user.getUid());
		List<User> list = concernBiz.getFans(user);
		jsonModel.setCode(1);
		jsonModel.setObj(list);
		
		super.printJson(jsonModel, ServletActionContext.getResponse());
	}
	
	@Action(value="concern_getConcernInfo")
	public void getFansInfo() throws IOException{
		User user =(User)ServletActionContext.getRequest().getSession().getAttribute(YcConstants.LOGINUSER);
		Concern cc  = new Concern();
		cc.setB_uid(user.getUid());
		List<User> list = concernBiz.getConcern(user);
		jsonModel.setCode(1);
		jsonModel.setObj(list);
		
		super.printJson(jsonModel, ServletActionContext.getResponse());
	}
	
	
}
