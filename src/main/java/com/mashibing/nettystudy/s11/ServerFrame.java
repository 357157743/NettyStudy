package com.mashibing.nettystudy.s11;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @date 2020/6/19 - 15:24
 */
public class ServerFrame extends Frame {

    public static final  ServerFrame INSTANCE = new ServerFrame();

    Button btnStart = new Button("start");
    TextArea taLeft = new TextArea();
    TextArea taRight  = new TextArea();
    Server server  = new Server();

    public ServerFrame(){
        this.setSize(1600,400);
        this.setLocation(300,30);
        this.add(btnStart,BorderLayout.NORTH);
        Panel p = new Panel(new GridLayout(1,2)); // 一行两列
        p.add(taLeft);
        p.add(taRight);
        this.add(p);

        //客户端点红色叉子 关闭
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.btnStart.addActionListener((e) ->{
            server.serverStart();
        });
        this.setVisible(true);
    }


    public static void main(String[] args) {
      new Server();
    }

    public void updateServerMsg(String s) {
        this.taLeft.setText( taLeft.getText() + System.getProperty("line.separator") + s);
    }
}
