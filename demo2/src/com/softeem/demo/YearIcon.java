package com.softeem.demo;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

//年份图标
public class YearIcon {

	BufferedImage img;	//图片对象
	int x;				//绘制的x轴
	int y = 100;				//绘制的y轴
	int width;			//宽度
	int height;			//高度
	
	public YearIcon(){
		//捕获异常
		try {
			//加载图片资源为URL对象
			URL url = this.getClass().getResource("/resource/t1.png");
			//加载url资源成为一个Image对象
			img = ImageIO.read(url);
			width = img.getWidth()/5;		//获取图片宽度（缩小图片为原来的1/5）
			height = img.getHeight()/5;	//获取图片高度（缩小图片为原来的1/5）
			x = (Settings.WIDTH - width)/2; //计算确定x轴位置
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
