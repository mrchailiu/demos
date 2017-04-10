package com.softeem.demo;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

//���ͼ��
public class YearIcon {

	BufferedImage img;	//ͼƬ����
	int x;				//���Ƶ�x��
	int y = 100;				//���Ƶ�y��
	int width;			//���
	int height;			//�߶�
	
	public YearIcon(){
		//�����쳣
		try {
			//����ͼƬ��ԴΪURL����
			URL url = this.getClass().getResource("/resource/t1.png");
			//����url��Դ��Ϊһ��Image����
			img = ImageIO.read(url);
			width = img.getWidth()/5;		//��ȡͼƬ��ȣ���СͼƬΪԭ����1/5��
			height = img.getHeight()/5;	//��ȡͼƬ�߶ȣ���СͼƬΪԭ����1/5��
			x = (Settings.WIDTH - width)/2; //����ȷ��x��λ��
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
