package com.softeem.ew.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 用于发起http请求的网络连接类
 * @author Administrator
 */
public class HttpRequest {

	public static InputStream read(String uri) throws IOException{
		InputStream is = null;
		//根据要请求的url地址构建一个URL对象
		URL url = new URL(uri);
		//打开到指定地址的连接
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		//设置请求方式为get
		conn.setRequestMethod("GET");
		//设置读取的超时时间
		conn.setReadTimeout(10000);
		//设置连接的超时时间
		conn.setConnectTimeout(5000);
		
		//获取响应码
		int stateCode = conn.getResponseCode();
		System.out.println("http response code:"+stateCode);
		if(stateCode == HttpURLConnection.HTTP_OK){
			//如果响应成功，则获取服务端响应回来的数据
			is = conn.getInputStream();
		}
		return is;
	}
}
