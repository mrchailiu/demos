package com.softeem.plane;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

//英雄机(我方飞机)
public class Hero {

	BufferedImage img;	//用于渲染飞机的图片
	int x;				//飞机绘制的x轴
	int y;				//飞机绘制的y轴
	int width;			//飞机宽度
	int height;			//飞机高度
	int flag = 1;		//标志位，标识使用哪一张图片渲染飞机
	Timer timer;		//声明定时器
	
	public Hero()
	{
		//获飞机的图片
		img = ImageLoader.load("hero1.png");
		width = img.getWidth()/2;
		height = img.getHeight()/2;
		x = (430-width)/2;
		y = 700 - height - 50;
		startShoot();
	}
	//开始射击
	public void startShoot()
	{
		//创建定时器
		timer = new Timer();
		//启动定时任务
		timer.schedule(new BulletTask(),0,200);
	}
	
	//创建一个定时任务，不断制造子弹
	class BulletTask extends TimerTask{
		@Override
		public void run() {
			//创建一颗子弹
			Bullet b = new Bullet(x+width/2,y);
			//将创建的子弹加入集合，以便在面板中绘制出来
			GamePanel.bullets.add(b);
			//启动子弹的运行线程
			b.start();
		}
	}
	
	//停止射击
	public void stopShoot()
	{
		
	}
	
	//移动飞机到指定位置
	public void moveTo(int x,int y){
		this.x = x - width/2;
		this.y = y - height/2;
		//防止飞机飞出可视区域
		if(this.x < 0){
			this.x = 0;
		}
		if(this.y < 0){
			this.y = 0;
		}
		if(this.x>(430-this.width-10)){
			this.x = 430-this.width-10;
		}
		if(this.y>(700-this.height - 30)){
			this.y = 700-this.height - 30;
		}
	}
}
