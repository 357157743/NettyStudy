package com.mashibing.nettystudy.s01;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @date 2020/6/15 - 10:25
 */
public class Client {
    public static void main(String[] args) {
        // 线程池
        EventLoopGroup group = new NioEventLoopGroup(); //不传参数 默认是核数的2倍 线程
        // 辅助启动类
        Bootstrap b = new Bootstrap();
        try {
              // 开启客户端 netty里面所有的方法都是异步的
             ChannelFuture f = b.group(group)
                    .channel(NioSocketChannel.class) // NioSocketChannel 非阻塞版 也可以写阻塞版SocketChannel
                    .handler(new ClientChannelInitializer())
                    .connect("localhost",8888) //connect 是异步方法
                    ;

             f.addListener(new ChannelFutureListener() {
                 @Override
                 public void operationComplete(ChannelFuture future) throws Exception {
                     if(! future.isSuccess()){
                         System.out.println("not success!");
                     }else{
                         System.out.println("connected!");
                     }
                 }
             });

             f.sync();
            System.out.println(".....");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully(); // 关闭客户端
        }
    }

}


class ClientChannelInitializer extends  ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        System.out.println(ch);
    }
}