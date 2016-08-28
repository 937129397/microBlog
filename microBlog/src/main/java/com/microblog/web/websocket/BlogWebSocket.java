package com.microblog.web.websocket;


import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.struts2.ServletActionContext;

import com.microblog.bean.User;


@ServerEndpoint(value = "/chat")
public class BlogWebSocket {

    private static final Set<BlogWebSocket> connections =
            new CopyOnWriteArraySet<>();

    private String nickname;
    private Session session;
    private Map<String, Object> session1;

    

    @OnOpen
    public void start(Session session) {
        this.session = session;
        this.session1= (Map<String, Object>) ServletActionContext.getRequest().getSession();
        User u=(User) session1.get("loginuser");
    	this.nickname =u.getNickname();
        connections.add(this);
    }

    @OnClose
    public void end() {
        connections.remove(this);
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
        for (BlogWebSocket client : connections) {
            try {
                synchronized (client) {
                    client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
            	System.out.println("Chat Error: Failed to send message to client");
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}