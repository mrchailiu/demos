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
 * ��ȡ�ļ�������в���齱����Ա
 * @author Administrator
 */
public class FileUtils {

	List<String> names;//����
	
	public FileUtils() {
		try {
			//��ʼ������
			names = new ArrayList<String>();
			//����url��ַ��ȡһ���ļ�����
			File f = new File("src/resource/data.txt");
			InputStream is = this.getClass().getResourceAsStream("/resource/data.txt");
			//
			InputStreamReader isr = new InputStreamReader(is);
			//���ͼ�����װΪ������
			BufferedReader br = new BufferedReader(isr);
			String str = "";
			//ѭ���Ķ�ȡ���е�����(һ��һ�ж�)
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
	//����
//	public static void main(String[] args) {
//		new FileUtils();
//	}
}
