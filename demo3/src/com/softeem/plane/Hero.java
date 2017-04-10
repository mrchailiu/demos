package com.softeem.plane;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

//Ӣ�ۻ�(�ҷ��ɻ�)
public class Hero {

	BufferedImage img;	//������Ⱦ�ɻ���ͼƬ
	int x;				//�ɻ����Ƶ�x��
	int y;				//�ɻ����Ƶ�y��
	int width;			//�ɻ����
	int height;			//�ɻ��߶�
	int flag = 1;		//��־λ����ʶʹ����һ��ͼƬ��Ⱦ�ɻ�
	Timer timer;		//������ʱ��
	
	public Hero()
	{
		//��ɻ���ͼƬ
		img = ImageLoader.load("hero1.png");
		width = img.getWidth()/2;
		height = img.getHeight()/2;
		x = (430-width)/2;
		y = 700 - height - 50;
		startShoot();
	}
	//��ʼ���
	public void startShoot()
	{
		//������ʱ��
		timer = new Timer();
		//������ʱ����
		timer.schedule(new BulletTask(),0,200);
	}
	
	//����һ����ʱ���񣬲��������ӵ�
	class BulletTask extends TimerTask{
		@Override
		public void run() {
			//����һ���ӵ�
			Bullet b = new Bullet(x+width/2,y);
			//���������ӵ����뼯�ϣ��Ա�������л��Ƴ���
			GamePanel.bullets.add(b);
			//�����ӵ��������߳�
			b.start();
		}
	}
	
	//ֹͣ���
	public void stopShoot()
	{
		
	}
	
	//�ƶ��ɻ���ָ��λ��
	public void moveTo(int x,int y){
		this.x = x - width/2;
		this.y = y - height/2;
		//��ֹ�ɻ��ɳ���������
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
