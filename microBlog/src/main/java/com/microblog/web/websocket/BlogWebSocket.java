package com.microblog.web.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.microblog.bean.Concern;
import com.microblog.bean.User;
import com.microblog.biz.ConcernBiz;


@ServerEndpoint(value = "/chat",configurator=GetHttpSessionConfigurator.class)
public class BlogWebSocket {
	// Map<userid,Set<BlogWebSocket>>
	private static Set<BlogWebSocket> b_connect;
	private static Set<BlogWebSocket> f_connect;

	private String nickname;
	private Session session;
	private static ServletContext application;
	private static ConcernBiz concernBiz;
	//取出spring容器  可以注入spring方法
	static ApplicationContext ac;
	private static HttpSession httpSession;
	// 1、取到所有用户的id， new Set<BlogWebSocket> 存进 Map
	// 2、用户登录成功，获取uid，

	@OnOpen
	public void start(Session session,EndpointConfig config) {
		this.session = session;
		httpSession= (HttpSession) config.getUserProperties().get("httpsession");
		ac=WebApplicationContextUtils.getWebApplicationContext(httpSession.getServletContext());
		
		/*session1 = (Map<String, Object>) ActionContext.getContext().getSession().put("loginuser", us);
		
		this.session1 = (Map<String, Object>) ServletActionContext.getRequest()
				.getSession();*/
		if(ac!=null){
			//取出业务层
			concernBiz=(ConcernBiz) ac.getBean("concernBizImpl");
			if (httpSession.getAttribute("loginuser") != null
					|| !"".equals(httpSession.getAttribute("loginuser"))) {
				User u = (User) httpSession.getAttribute("loginuser");
				this.nickname = u.getNickname();
				Concern c = new Concern();
				c.setF_uid(u.getUid());
				List<Integer> b_uids = concernBiz.getBidByFid(c);

				application = httpSession.getServletContext();
				for (Integer uid : b_uids) {
					Map<String, Set<BlogWebSocket>> con = (Map<String, Set<BlogWebSocket>>)application
							.getAttribute("allCon");
					b_connect = con.get(uid + "");
					b_connect.add(this);
				}
			}
		}
		
	}

	@OnClose
	public void end() {
		if (httpSession.getAttribute("loginuser") != null
				|| !"".equals(httpSession.getAttribute("loginuser"))) {
			User u = (User) httpSession.getAttribute("loginuser");
			this.nickname = u.getNickname();
			Concern c = new Concern();
			c.setF_uid(u.getUid());
			List<Integer> b_uids = concernBiz.getBidByFid(c);

			for (Integer uid : b_uids) {
				@SuppressWarnings("unchecked")
				Map<String, Set<BlogWebSocket>> con = (Map<String, Set<BlogWebSocket>>) application
						.getAttribute("allCon");
				b_connect = con.get(uid + "");
				b_connect.remove(this);
			}
		}
	}

	@OnMessage
	public void incoming(String message) {
		// Never trust the client
		// TODO: 过滤输入的内容
		broadcast(message);
	}

	@OnError
	public void onError(Throwable t) throws Throwable {
		System.out.println("Chat Error: " + t.toString());
	}

	private static void broadcast(String msg) {
		if (httpSession.getAttribute("loginuser") != null
				|| !"".equals(httpSession.getAttribute("loginuser"))) {
			User u = (User)httpSession.getAttribute("loginuser");
			int f_uid = u.getUid();

			@SuppressWarnings("unchecked")
			Map<String, Set<BlogWebSocket>> con = (Map<String, Set<BlogWebSocket>>) application
					.getAttribute("allCon");
			f_connect = con.get(f_uid + "");

		}
		for (BlogWebSocket client : f_connect) {
			try {
				synchronized (client) {
					client.session.getBasicRemote().sendText(msg);
				}
			} catch (IOException e) {
				System.out
						.println("Chat Error: Failed to send message to client");
				b_connect.remove(client);
				try {
					client.session.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	
}