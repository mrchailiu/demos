package com.softeem.exp.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequest {

	public static String send(String url){
		System.out.println("请求地址---->"+url);
		String json = ErrorCode.OTHER_ERROR;
		HttpURLConnection conn = null;
		BufferedReader br = null;
		try {
			URL reqUrl = new URL(url);
			conn = (HttpURLConnection) reqUrl.openConnection();
			
          conn.setRequestProperty("accept", "*/*");  	//设置通用的请求属性
			conn.addRequestProperty("charset", "utf-8");//设置请求编码
			conn.setRequestMethod("POST");				//设置请求方式
			conn.setDoOutput(true);						//设置开启输出
			conn.setDoInput(true);						//设置开启输入
			conn.setUseCaches(false);					//关闭缓存
			conn.connect();								//打开连接
			
			int stateCode = conn.getResponseCode();		//获取响应编码
			if(stateCode == HttpURLConnection.HTTP_OK){
				//200
				InputStream is = conn.getInputStream();	//获取输入流（返回数据）
				br = new BufferedReader(new InputStreamReader(is,"utf-8"));
				StringBuffer buff = new StringBuffer();
				while((json = br.readLine()) != null){
					buff.append(json);
				}
				json = buff.toString();
				System.out.println("....>"+json);
			}else if(stateCode == HttpURLConnection.HTTP_NOT_FOUND){
				//404
				json = ErrorCode.NOT_FOUND;
			}else if(stateCode == HttpURLConnection.HTTP_INTERNAL_ERROR){
				//500
				json = ErrorCode.SERVER_ERROR;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(conn != null){
				conn.disconnect();
			}
		}
		return json;
	}
	
	/**
	 * 发送在线请求
	 * @param type		快递商代码
	 * @param postid	快递单号
	 * @return		返回json数据
	 */
	public static String sendOnLine(String url,String type,String postid){
		String query = "/queryOnline";
		String param = "type="+type+"&postid="+postid;
		url = url+query+"?"+param;
		System.out.println(url);
		return send(url);
	}
	
	/**
	 * 发送离线请求
	 * @param postid	快递单号
	 * @return	返回json数据
	 */
	public static String sendOffLine(String url,String postid){
		String query = "/query";
		String param = "postid="+postid;
		url = url+query+"?"+param;
		return send(url);
	}
	
}
