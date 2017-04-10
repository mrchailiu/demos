package com.softeem.plane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
//游戏主窗体
public class MainUI extends JFrame{
	//创建游戏面板
	GamePanel panel = new GamePanel();
	
	public MainUI()
	{
		setSize(430,700);
		setTitle("SOFTEEM打飞机(by MRChai)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//当窗体关闭时自动关闭虚拟机
		setResizable(false);	//固定窗体大小
		setLocationRelativeTo(null); //窗体在屏幕中居中
		add(panel); //添加面板到窗体中
		setVisible(true);
		//为窗体添加事件
		addWindowListener(new WindowClose());
	}
	
	//窗体事件
	class WindowClose extends WindowAdapter{
		//当窗体被关闭时，停止播放
		@Override
		public void windowClosed(WindowEvent e) {
			super.windowClosed(e);
			panel.sl.stop();
		}
	}
	
	public static void main(String[] args) {
		new MainUI();
	}

}
