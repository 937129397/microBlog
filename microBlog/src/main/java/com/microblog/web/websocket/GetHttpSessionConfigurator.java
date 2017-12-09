package com.microblog.web.websocket;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
//配置类  将http中的session传入websocket中
public class GetHttpSessionConfigurator extends  ServerEndpointConfig.Configurator {
	 @Override
	    public void modifyHandshake(ServerEndpointConfig sec,
	            HandshakeRequest request, HandshakeResponse response) {
	        // TODO Auto-generated method stub
	        HttpSession httpSession=(HttpSession) request.getHttpSession();
	        sec.getUserProperties().put("httpsession",httpSession);
	    }
}
