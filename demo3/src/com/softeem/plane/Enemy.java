package com.softeem.plane;

import java.awt.image.BufferedImage;
import java.util.Random;

//�л���(ÿһ�ܵл�����һ�������߳�)
public class Enemy extends Thread{

	BufferedImage img;	//�л�ͼƬ
	int x;		//�ɻ����ֵ�x��λ��(���)
	int y;
	int width;
	int height;
	int type;	//�ɻ����� 0:���ӻ�		1:�ְֻ�		2:үү��   �������
	int score;	//�÷���� С:100		��:300		��:500
	int blood;  //�ɻ�������Ҫ����������	С:1		��:5		��:10
	int speed;	//�����ٶ�(���)
	
	public Enemy()
	{
		//���ڲ�����������������
		Random r = new Random();
		//���һ���ɻ�����(С:7  ��:2  ��:1)
		int i = r.nextInt(10) + 1;//1~10
		//�����ȡ�ɻ����Ͳ����õ÷��Լ�Ѫ��
		if(i % 5 == 0){
			//���ͻ�
			type = 1;
			score = 300;
			blood = 5;
		}else if(i % 9 == 0){
			//���ͻ�
			type = 2;
			score = 500;
			blood = 10;
		}else{
			//С�ͻ�
			type = 0;
			score = 100;
			blood = 1;
		}
		img = ImageLoader.load("enemy"+type+".png");//��������ȷ���ɻ�ͼƬ
		width = img.getWidth()/2;
		height = img.getHeight()/2;
		y = -height;//����y��λ��Ϊ���߶�(��������Ļ�ⲿ����Ĺ���)
		x = r.nextInt(430);//���x��(0~429)
		speed = r.nextInt(10)+5;//����ٶ�(5~14)
		//��ֹ�ɻ����������߷�Χ֮��
		if(x>(430-width-10)){
			x = 430-width-10;
		}
	}
	
	//ʵ�ֵл��˶��켣
	public void run()
	{
		while(true){
			y += speed;//���������ƶ��ɻ�
			//�жϵл��Ƿ��Ѿ��ɵ�����������ײ�
			if(y>700){
				//�Ӽ������Ƴ��л�
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
