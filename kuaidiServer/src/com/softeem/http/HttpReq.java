package com.softeem.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpReq {

	public static String request(String url) throws IOException{
		String json = "";
		
		URL httpUrl = new URL(url);
		HttpURLConnection conn = (HttpURLConnection)httpUrl.openConnection();
//        conn.setAllowUserInteraction(false);
		conn.setDoInput(true);        //设置输入流采用字节流
        conn.setDoOutput(true);        //设置输出流采用字节流
        conn.setRequestMethod("GET");
        conn.setUseCaches(true);    //设置缓存
//        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Charset", "utf-8");
        
        conn.connect();
		//获取响应的状态码（如果200则说明响应成功）
		int code = conn.getResponseCode();
		if(code == HttpURLConnection.HTTP_OK){
			InputStream is = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
			StringBuffer sb = new StringBuffer();
			json = "";
			while((json = br.readLine())!= null){
				sb.append(json);
			}
			json = sb.toString();
			if(conn != null){
				conn.disconnect();
				br.close();
			}
		}
		return json;
	}
	
}
