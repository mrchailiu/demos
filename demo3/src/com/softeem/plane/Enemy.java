package com.softeem.plane;

import java.awt.image.BufferedImage;
import java.util.Random;

//敌机类(每一架敌机都是一个单独线程)
public class Enemy extends Thread{

	BufferedImage img;	//敌机图片
	int x;		//飞机出现的x轴位置(随机)
	int y;
	int width;
	int height;
	int type;	//飞机类型 0:儿子机		1:爸爸机		2:爷爷机   （随机）
	int score;	//得分情况 小:100		中:300		大:500
	int blood;  //飞机销毁需要被攻击次数	小:1		中:5		大:10
	int speed;	//飞行速度(随机)
	
	public Enemy()
	{
		//用于产生随机数的随机对象
		Random r = new Random();
		//随机一个飞机类型(小:7  中:2  大:1)
		int i = r.nextInt(10) + 1;//1~10
		//计算获取飞机类型并设置得分以及血量
		if(i % 5 == 0){
			//中型机
			type = 1;
			score = 300;
			blood = 5;
		}else if(i % 9 == 0){
			//大型机
			type = 2;
			score = 500;
			blood = 10;
		}else{
			//小型机
			type = 0;
			score = 100;
			blood = 1;
		}
		img = ImageLoader.load("enemy"+type+".png");//根据类型确定飞机图片
		width = img.getWidth()/2;
		height = img.getHeight()/2;
		y = -height;//设置y轴位置为负高度(看到从屏幕外部飞入的过程)
		x = r.nextInt(430);//随机x轴(0~429)
		speed = r.nextInt(10)+5;//随机速度(5~14)
		//防止飞机出现在视线范围之外
		if(x>(430-width-10)){
			x = 430-width-10;
		}
	}
	
	//实现敌机运动轨迹
	public void run()
	{
		while(true){
			y += speed;//不断向下移动飞机
			//判断敌机是否已经飞到可视区域最底部
			if(y>700){
				//从集合中移除敌机
				GamePanel.planes.remove(Enemy.this);
				break;
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
