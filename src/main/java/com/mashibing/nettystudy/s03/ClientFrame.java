package com.mashibing.nettystudy.s03;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @date 2020/6/19 - 15:24
 */
public class ClientFrame extends Frame {
    TextArea ta = new TextArea();
    TextField tf  = new TextField();

    public ClientFrame(){
        this.setSize(600,400);
        this.setLocation(100,20);
        this.add(ta,BorderLayout.CENTER);
        this.add(tf,BorderLayout.SOUTH);

        tf.addActionListener(new ActionListener() {
            // 把字符串发送到服务器
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText(ta.getText() + tf.getText());
                tf.setText("");
            }
        });
        this.setVisible(true);
        // 窗口显示完毕后 调用New client().connectC();
        new Client().connect();
    }

    public static void main(String[] args) {
       new ClientFrame();

    }
}