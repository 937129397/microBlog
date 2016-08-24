package com.microblog.web.actions;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.microblog.bean.User;
import com.microblog.biz.UserBiz;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope(value = "prototype")
@Namespace("/")
@ParentPackage("struts-default")
public class UserAction extends BaseAction implements ModelDriven<User>{
	private static final long serialVersionUID = -7958780916496829538L;
	private User user;
	private UserBiz userBiz;

	@Override
	public User getModel() {
		user = new User();
		return user;
	}
	
	@Resource(name="userBizImpl")
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
	//判断 该email是否已经被注册
	public void validateRegister() throws IOException {
		if (userBiz.validate(user) || userBiz.validate1(user)) {
			jsonModel.setCode(0);
			jsonModel.setMsg("username exists, please choose another one...");
			//super.outJson(jsonModel, ServletActionContext.getResponse());
			//return;
		}
	}
	
	@Action(value = "/user_register")
	public void register() throws IOException {
		if(    jsonModel.getCode()==null){
			userBiz.register(user);
			jsonModel.setCode(1);
		}
		super.printJson(jsonModel, ServletActionContext.getResponse());
		
	}
	
	@Action(value = "/user_loginByEmail")
	public void login() throws Exception {
		if(   jsonModel.getCode()==null ){
			User user = userBiz.loginByEmail(this.user);
			if (null != user) {
				Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("loginuser", user);
				jsonModel.setCode(1);
				user.setPassword(null);
				jsonModel.setObj( user);
			}else{
				jsonModel.setCode(0);
				jsonModel.setMsg("error username or password");
			}
		}
		super.printJson(jsonModel, ServletActionContext.getResponse());
		
	}
	
	@Action(value = "/user_loginByTelephone")
	public void login2() throws Exception {
		if(   jsonModel.getCode()==null ){
			User user = userBiz.loginByTelephone(this.user);
			if (null != user) {
				Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("loginuser", user);
				jsonModel.setCode(1);
				user.setPassword(null);
				jsonModel.setObj( user);
			}else{
				jsonModel.setCode(0);
				jsonModel.setMsg("error username or password");
			}
		}
		super.printJson(jsonModel, ServletActionContext.getResponse());
		
	}

}
