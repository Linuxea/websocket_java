package com.linuxea.controller;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * Created by Linuxea on 10/22/17.
 */
@ServerEndpoint("/websocket")
@Component
public class WebSocketController {

    private Session session;

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        System.out.println("open......");
    }

    @OnClose
    public void onClose(){
        System.out.println("close ........");
    }

    @OnMessage
    public void onMessage(String message){
        System.out.println(message);
        try {
            while (true) {
                // 建立 ws 连接并进行服务端的自主推送
                String now = Instant.now().toString();
                this.session.getBasicRemote().sendText(now + ":" + message);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
