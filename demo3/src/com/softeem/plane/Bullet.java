package com.softeem.plane;

import java.awt.image.BufferedImage;

//每一颗子弹都有自己的运行轨迹(线程)
public class Bullet extends Thread{

	BufferedImage img;		//子弹图片
	int x;					//绘制的x轴
	int y;					//子弹绘制y轴
	int width;				//宽度
	int height;				//高度
	int speed=20;				//飞行速度
	
	public Bullet(int x,int y)
	{
		img = ImageLoader.load("bullet2.png");
		width = img.getWidth()/2;
		height = img.getHeight()/2;
		this.x = x;
		this.y = y;
	}
	
	//实现子弹的移动
	public void run(){
		while(true){
			//不断改变y轴位置(移动子弹)
			y -= speed;
			//判断子弹是否已经飞出屏幕的边界
			if(y < 0){
				//将子弹从集合中移除
				GamePanel.bullets.remove(Bullet.this);
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
