package com.microblog.web.actions;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.microblog.bean.Concern;
import com.microblog.bean.User;
import com.microblog.biz.ConcernBiz;
import com.microblog.biz.UserBiz;
import com.microblog.util.YcConstants;
import com.microblog.web.model.UserModel;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope(value = "prototype")
@Namespace("/")
@ParentPackage("struts-default")
public class ConcernAction extends BaseAction implements ModelDriven<UserModel>{
	private ConcernBiz concernBiz;
	private UserBiz userBiz;
	private UserModel userModel;
	
	
	@Resource(name="userBizImpl")
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	@Resource(name="concernBizImpl")
	public void setConcernBiz(ConcernBiz concernBiz) {
		this.concernBiz = concernBiz;
	}


	private static final long serialVersionUID = 565115697626641827L;
	
	
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
	
	@Action(value = "/user_getAllCount")
	public void getBlogCount() throws IOException{
		Concern cc  = new Concern();
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute(YcConstants.LOGINUSER);
		Integer i = userBiz.findUserBlogCount(user);
		if(i==null){
			i=0;
		}
		userModel.setBlogCount(i);
		
		cc.setB_uid(user.getUid());
		Integer j = concernBiz.getFansCount(cc);
		if(j==null){
			j=0;
		}
		userModel.setFanCount(j);
		
		cc.setB_uid(user.getUid());
		Integer k = concernBiz.getConcernCount(cc);
		if(k==null){
			k=0;
		}
		userModel.setConcernCount(k);
		
		jsonModel.setCode(1);
		jsonModel.setObj(userModel);
		super.printJson(jsonModel, ServletActionContext.getResponse());
	}

	@Override
	public UserModel getModel() {
		userModel = new UserModel();
		return userModel;
	}
	
}
