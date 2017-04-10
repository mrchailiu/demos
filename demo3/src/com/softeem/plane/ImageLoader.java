package com.softeem.plane;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

//加载图片的工具类
public class ImageLoader {

	//根据传入图片名称加载图片对象
	public static BufferedImage load(String name)
	{
		try {
			//加载指定的资源为URL对象
			URL url = ImageLoader.class.getResource("/images/"+name);
			//加载url指定的图片为一个Image对象并返回
			return ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
