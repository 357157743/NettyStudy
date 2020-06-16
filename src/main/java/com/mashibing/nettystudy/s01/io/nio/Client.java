package com.mashibing.nettystudy.s01.io.nio;

import java.io.IOException;
import java.net.Socket;

/**
 * @date 2020/6/15 - 10:27
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",8888);
        s.getOutputStream().write("HelloServer".getBytes());
        s.getOutputStream().flush();

        System.out.println("write over,waitting for msg back...");
        byte[] bytes = new byte[1024];
        int len = s.getInputStream().read(bytes);
        System.out.println(new String(bytes,0,len));
        s.close();
    }
}
