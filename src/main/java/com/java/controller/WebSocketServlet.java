package com.java.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/websocket/ride/orderManage/{userId}")
@Component
@Slf4j
public class WebSocketServlet {
    //链接人数
    private static int onlineCount = 0;
    //socket存储
    private static Map<String, WebSocketServlet> clients = new ConcurrentHashMap<>();
    private Session session;
    private String userId;

    //private static BookRideOrderService bookRideOrderService;


    /*@Resource
    public void setBookRideOrderService(BookRideOrderService bookRideOrderService){
        RideOrderWebSocketServlet.bookRideOrderService = bookRideOrderService;
    }*/

    //连接建立
    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) throws IOException {

        this.userId = userId;
        this.session = session;
        addOnlineCount();
        clients.put(userId, this);
        log.info("----------------------------->用户链接："+userId);
        sendMessageTo("已连接",userId);
    }
    //关闭连接
    @OnClose
    public void onClose() throws IOException {
        log.info("-------------------------->关闭链接userId:"+userId);
        log.info("修改当前用户工作状态:RideOrderWebSocketServlet-->onClose 参数status:0");
        //Boolean boo=bookRideOrderService.updateUserInfo(Long.parseLong(userId),"0");
       // log.info("修改当前用户工作状态:RideOrderWebSocketServlet-->onClose 返回参数boo:"+boo);
        clients.remove(userId);
        subOnlineCount();
    }
    //接收消息
    @OnMessage
    public void onMessage(String message) throws IOException {
        log.info("----------------------------->消息："+message);
    }
    //连接出错
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    //定向向web端发送消息自己封装数据
    public void sendMessageTo(String message, String To) throws IOException {
        log.info("websocket------------》发送消息：{}，接收对象id：{}",message,To);
        for (WebSocketServlet item : clients.values()) {
            if (item.userId.equals(To) ){
                item.session.getAsyncRemote().sendText(message);
                log.info("websocket------------》已经发送消息：{}，接收对象id：{}",message,To);

            }
        }
    }
    //向所有web端发送消息自己封装数据
    public void sendMessageAll(String message) throws IOException {
        log.info("websocket------------》发送消息：{}",message);
        for (WebSocketServlet item : clients.values()) {
            item.session.getAsyncRemote().sendText(message);
        }
        log.info("websocket------------》已经发送消息：{}",message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServlet.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServlet.onlineCount--;
    }

    public static synchronized Map<String, WebSocketServlet> getClients() {
        return clients;
    }
}
