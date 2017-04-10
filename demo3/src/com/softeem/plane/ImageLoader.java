package com.softeem.plane;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

//����ͼƬ�Ĺ�����
public class ImageLoader {

	//���ݴ���ͼƬ���Ƽ���ͼƬ����
	public static BufferedImage load(String name)
	{
		try {
			//����ָ������ԴΪURL����
			URL url = ImageLoader.class.getResource("/images/"+name);
			//����urlָ����ͼƬΪһ��Image���󲢷���
			return ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
