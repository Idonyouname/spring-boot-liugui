package com.example.springbootnettyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

@SpringBootApplication
public class SpringBootNettyServerApplication {

    public static void main(String[] args) {


        SpringApplication.run(SpringBootNettyServerApplication.class, args);

        //启动服务器
        NettyServer server = new NettyServer();
        server.start(new InetSocketAddress("127.0.0.1",9998));

    }

}
