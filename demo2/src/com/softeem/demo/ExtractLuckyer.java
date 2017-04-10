package com.softeem.demo;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class ExtractLuckyer extends JFrame{

	public ExtractLuckyer(){
	
		setSize(Settings.WIDTH,Settings.HEIGHT);	//设置窗体大小
		setTitle(Settings.TITLE);					//设置标题
		setLocationRelativeTo(null);				//设置窗体默认居中
		setResizable(false);						//禁止改变窗体大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//关闭窗体自动退出虚拟机
		final MyPanel panel = new MyPanel();
		add(panel);//将面板加入窗体
		setVisible(true);							//显示窗体
		//让面板获取焦点
		panel.requestFocus();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
				if(panel.clip != null){
					panel.clip.stop();
					System.exit(0);
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new ExtractLuckyer();
	}
}
