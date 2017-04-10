package com.softeem.demo;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/*
 	主面板
 */
public class MyPanel extends JPanel{

	BufferedImage bg;//面板的背景图片
	YearIcon icon = new YearIcon();//创建年份图标对象
	String tips = "回车开始";
	boolean flag;//标志位，标识是否开始抽取
	FileUtils utils;
	Timer timer;//声明定时器
	KeyLis kl;
	AudioClip clip;
	
	//构造器(构造方法，构造函数)
	public MyPanel()
	{
		utils = new FileUtils();
		//捕获异常
		try {
			clip = Applet.newAudioClip(this.getClass().getResource("/resource/bgmusic.wav"));
			//加载图片资源为URL对象
			URL url = this.getClass().getResource("/resource/08.jpg");
			//加载url资源成为一个Image对象
			bg = ImageIO.read(url);
			//启动音乐播放线程
			new MusicThread().start();
			//为面板设置按键事件监听器
			kl = new KeyLis();
			addKeyListener(kl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//用于播放背景音乐的线程
	class MusicThread extends Thread{
		public void run(){
			//加载背景音乐并播放
			clip.loop();//循环播放
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//绘制背景图片
		g.drawImage(bg, 0, 0, Settings.WIDTH, Settings.HEIGHT, null);
		//绘制年份艺术字图片
		g.drawImage(icon.img, icon.x, icon.y, icon.width, icon.height, null);
		//设置字体大小
		g.setFont(new Font("微软雅黑", Font.BOLD, 40));
		//设置画笔的颜色
		g.setColor(Color.WHITE);
		g.drawString(tips, Settings.WIDTH/2-80, Settings.HEIGHT/2);
	}
	
	//创建按键事件监听器
	class KeyLis extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			//获取按键的按键码
			int code = e.getKeyCode();
			//判断是否按下回车键
			if(code == 10){
				if(flag){
					//停止
					stop();
					flag = false;
				}else{
					//开始
					begin();
					flag = true;
				}
			}
		}
	}
	//开始抽取
	public void begin(){
		//创建定时器
		timer = new Timer();
		//启动定时任务
		timer.schedule(new RefreshTask(),0,50);
	}
	
	//创建不断刷新抽奖者任务
	class RefreshTask extends TimerTask{
		@Override
		public void run() {
			//创建随机对象
			Random r = new Random();
			//随机索引
			int i = r.nextInt(utils.names.size());//0~(length-1)
			//根据随机生成的索引获取名称
			tips = utils.names.get(i);
			//界面重绘
			repaint();
		}
	}
	
	//停止抽取
	public void stop(){
		//取消定时任务
		timer.cancel();
		//从集合中移除已中奖的幸运儿
		utils.names.remove(tips);
		//是否没有可抽奖的参与者
		if(utils.names.size()<=0){
			tips = "抽奖结束";
			//移除事件监听器
			removeKeyListener(kl);
		}
		repaint();//重绘界面
	}
}
