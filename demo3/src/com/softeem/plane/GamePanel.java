package com.softeem.plane;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

//游戏主面板:所有的游戏物体都在改界面绘制
public class GamePanel extends JPanel implements MouseMotionListener{
	
	BufferedImage bg;
	Hero hero = new Hero();//创建英雄机
	Timer timer;//声明定时器
	int bgY;//声明背景的y轴(不断修改y轴值,实现滚动效果)
	int speed = 10;//背景的改变速度(每次改变多少像素)
	//创建一个用于存储所有子弹的集合
	static List<Bullet> bullets = new ArrayList<Bullet>();
	//创建一个用于存储所有敌机的集合
	static List<Enemy> planes = new ArrayList<Enemy>();
	SoundLoader sl;//声明音频播放对象
	
	public GamePanel()
	{
		//加载并获取背景图片
		bg = ImageLoader.load("background.png");
		//初始背景图显示的位置
		bgY = 700 - bg.getHeight();
		startGame();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//绘制游戏的背景图片
		g.drawImage(bg, 0, bgY, bg.getWidth(), bg.getHeight(), null);
		//绘制英雄机
		g.drawImage(hero.img, hero.x, hero.y, hero.width, hero.height, null);
		//绘制子弹
		for(int i = 0;i<bullets.size();i++)
		{
			//取得每一颗子弹
			Bullet b = bullets.get(i);
			g.drawImage(b.img, b.x, b.y, b.width, b.height, null);
		}
		//绘制敌机
		for(int i = 0;i<planes.size();i++)
		{
			//获取每一架敌机
			Enemy e = planes.get(i);
			g.drawImage(e.img, e.x, e.y, e.width, e.height, null);
		}
	}
	
	//开始游戏
	public void startGame()
	{
		//创建定时器
		timer = new Timer();
		//启动定时任务
		timer.schedule(new RefreshTask(),0,100);
		//启动创建敌机的定时任务
		timer.schedule(new EnemyTask(),0,500);
		//为面板添加鼠标事件
		addMouseMotionListener(this);
		//播放背景音乐(在线程中实现)
		new Thread(){
			public void run()
			{
				sl = new SoundLoader("game_music.wav");
				sl.loop();
			}
		}.start();
	}
	
	//创建一个产生敌机的任务
	class EnemyTask extends TimerTask{
		@Override
		public void run() {
			//产生一架敌机
			Enemy e = new Enemy();
			//将敌机加入集合
			planes.add(e);
			//启动敌机的飞行线程
			e.start();
		}
	}
	
	//创建一个定时刷新界面的任务
	class RefreshTask extends TimerTask{
		@Override
		public void run() {
			//不断修改flag值
			if(hero.flag == 1){
				hero.flag = 2;
			}else{
				hero.flag = 1;
			}
			//根据flag值选择使用指定图片渲染飞机
			hero.img = ImageLoader.load("hero"+hero.flag+".png");
			//修改背景图的y轴位置
			bgY += speed;
			if(bgY > 0){
				//当背景图片已经显示到最顶部时，将位置还原到最底部
				bgY = 700 - bg.getHeight();
			}
			//让界面重绘
			repaint();
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("别拽了，骚年，没有用的!");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//获取目前鼠标指针所在的坐标
		int x = e.getX();
		int y = e.getY();
		System.out.println("当前坐标x="+x+",y="+y);
		hero.moveTo(x, y);
	}
	
}
