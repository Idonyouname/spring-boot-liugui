package com.liugui.springbootwebsocket.controller;

import com.liugui.springbootwebsocket.server.WebSocketServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @ClassName: WebSocketController
 * @Author: liugui
 * @Date: 2019-12-17 18:27
 **/
@RestController
@RequestMapping("/api/webSocket")
public class WebSocketController {

    /**
     * 群发消息
     */
    @RequestMapping(value = "/sendAll",method = RequestMethod.GET)
    public String sendAllMessage(String message){
        try {
            WebSocketServer.broadCastInfo(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    /**
     * 指定会话id
     */
    @RequestMapping(value = "/sendOne",method = RequestMethod.GET)
    public  String sendOneMessage(String message,String id){
        try {
            WebSocketServer.sendMessage(id,message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }



}
