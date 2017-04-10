package com.softeem.demo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//面向对象:封装，继承，多态
public class MyFrame extends JFrame{

	public MyFrame(){
		this.setSize(500,400);	//设置窗体大小(宽度，高度)
		this.setTitle("正在聊天..."); //设置标题
		this.setResizable(false);	//禁止改变窗体大小
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认的关闭选项(当窗体关闭虚拟自动关闭)
		this.setLocationRelativeTo(null);//设置窗体默认在屏幕正中间
		//将面板加入到窗体中
		this.add(new MyPanel());
		this.setVisible(true);	//设置窗体可见
	}
	//面板类
	class MyPanel extends JPanel{
		//声明输入框，文本域，按钮
		JTextField inputIp;
		JTextArea inputMsg;
		JButton btnSend;
		
		public MyPanel(){
			//创建输入框，文本域，按钮
			inputIp = new JTextField();
			inputMsg = new JTextArea();
			btnSend = new JButton("发送一波消息");
			//设置布局方式(自由)
			setLayout(null);
			inputIp.setBounds(10, 10, 470, 30);//设置文本框摆放的位置与大小
			this.add(inputIp);//将文本框加入面板中
			
			inputMsg.setBounds(10, 50, 470, 240);//设置文本域的位置与大小
			this.add(inputMsg);//将文本域加入到面板中
			
			btnSend.setBounds(350,310,130,35);//设置按钮的位置与大小
			this.add(btnSend);//将按钮加入面板中
			
			setBackground(Color.DARK_GRAY);//设置面板的背景颜色
			//为按钮添加点击事件
			btnSend.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 完成消息的发送
					//获取消息接收人的ip地址
					String ip = inputIp.getText();
					//获取需要发送的消息内容
					String msg = inputMsg.getText();
					//创建消息发送工具对象
					MyFeiQ f = new MyFeiQ();
					try {
						//发送消息
						f.sendMsg(ip, msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MyFrame();
	}

}
