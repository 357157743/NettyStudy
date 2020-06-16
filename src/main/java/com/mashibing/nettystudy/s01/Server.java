package com.mashibing.nettystudy.s01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @date 2020/6/16 - 9:51
 */
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss  = new ServerSocket();
        ss.bind(new InetSocketAddress(8888));

        Socket s  = ss.accept(); //阻塞方法 没有请求进来的话 一直卡到这里
        System.out.println("a client connect!");

    }
}
