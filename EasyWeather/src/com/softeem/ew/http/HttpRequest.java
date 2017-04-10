package com.softeem.ew.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ���ڷ���http���������������
 * @author Administrator
 */
public class HttpRequest {

	public static InputStream read(String uri) throws IOException{
		InputStream is = null;
		//����Ҫ�����url��ַ����һ��URL����
		URL url = new URL(uri);
		//�򿪵�ָ����ַ������
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		//��������ʽΪget
		conn.setRequestMethod("GET");
		//���ö�ȡ�ĳ�ʱʱ��
		conn.setReadTimeout(10000);
		//�������ӵĳ�ʱʱ��
		conn.setConnectTimeout(5000);
		
		//��ȡ��Ӧ��
		int stateCode = conn.getResponseCode();
		System.out.println("http response code:"+stateCode);
		if(stateCode == HttpURLConnection.HTTP_OK){
			//�����Ӧ�ɹ������ȡ�������Ӧ����������
			is = conn.getInputStream();
		}
		return is;
	}
}
