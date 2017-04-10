package com.softeem.plane;

import java.awt.image.BufferedImage;

//ÿһ���ӵ������Լ������й켣(�߳�)
public class Bullet extends Thread{

	BufferedImage img;		//�ӵ�ͼƬ
	int x;					//���Ƶ�x��
	int y;					//�ӵ�����y��
	int width;				//���
	int height;				//�߶�
	int speed=20;				//�����ٶ�
	
	public Bullet(int x,int y)
	{
		img = ImageLoader.load("bullet2.png");
		width = img.getWidth()/2;
		height = img.getHeight()/2;
		this.x = x;
		this.y = y;
	}
	
	//ʵ���ӵ����ƶ�
	public void run(){
		while(true){
			//���ϸı�y��λ��(�ƶ��ӵ�)
			y -= speed;
			//�ж��ӵ��Ƿ��Ѿ��ɳ���Ļ�ı߽�
			if(y < 0){
				//���ӵ��Ӽ������Ƴ�
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
