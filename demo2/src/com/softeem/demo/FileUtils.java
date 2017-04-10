package com.softeem.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取文件获得所有参与抽奖的人员
 * @author Administrator
 */
public class FileUtils {

	List<String> names;//数组
	
	public FileUtils() {
		try {
			//初始化集合
			names = new ArrayList<String>();
			//根据url地址获取一个文件对象
			File f = new File("src/resource/data.txt");
			InputStream is = this.getClass().getResourceAsStream("/resource/data.txt");
			//
			InputStreamReader isr = new InputStreamReader(is);
			//将低级流包装为缓冲流
			BufferedReader br = new BufferedReader(isr);
			String str = "";
			//循环的读取流中的数据(一行一行读)
			while((str = br.readLine()) != null)
			{
				names.add(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//测试
//	public static void main(String[] args) {
//		new FileUtils();
//	}
}
