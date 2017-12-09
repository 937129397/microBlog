package com.microblog.web.listeners;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.microblog.bean.User;
import com.microblog.biz.UserBiz;
import com.microblog.web.websocket.BlogWebSocket;

@WebListener
public class InitListener implements ServletContextListener{
	private UserBiz userBiz;

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//取出spring容器
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
		if(ac!=null){
			//取出业务层
			userBiz=(UserBiz) ac.getBean("userBizImpl");
			//查出所有的用户ID
			List<Integer> userId=this.userBiz.getUidList();
			//存入Map中
			Map<String,Set<BlogWebSocket>> con=new HashMap<String,Set<BlogWebSocket>>();
			for (int user : userId) {
				con.put(user+"", new HashSet<BlogWebSocket>());
			}
			
			ServletContext application = arg0.getServletContext();
			application.setAttribute("allCon", con);
			System.out.println(application.getAttribute("allCon"));
		}	
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}
