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
		System.out.println("�����ַ---->"+url);
		String json = ErrorCode.OTHER_ERROR;
		HttpURLConnection conn = null;
		BufferedReader br = null;
		try {
			URL reqUrl = new URL(url);
			conn = (HttpURLConnection) reqUrl.openConnection();
			
          conn.setRequestProperty("accept", "*/*");  	//����ͨ�õ���������
			conn.addRequestProperty("charset", "utf-8");//�����������
			conn.setRequestMethod("POST");				//��������ʽ
			conn.setDoOutput(true);						//���ÿ������
			conn.setDoInput(true);						//���ÿ�������
			conn.setUseCaches(false);					//�رջ���
			conn.connect();								//������
			
			int stateCode = conn.getResponseCode();		//��ȡ��Ӧ����
			if(stateCode == HttpURLConnection.HTTP_OK){
				//200
				InputStream is = conn.getInputStream();	//��ȡ���������������ݣ�
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
	 * ������������
	 * @param type		����̴���
	 * @param postid	��ݵ���
	 * @return		����json����
	 */
	public static String sendOnLine(String url,String type,String postid){
		String query = "/queryOnline";
		String param = "type="+type+"&postid="+postid;
		url = url+query+"?"+param;
		System.out.println(url);
		return send(url);
	}
	
	/**
	 * ������������
	 * @param postid	��ݵ���
	 * @return	����json����
	 */
	public static String sendOffLine(String url,String postid){
		String query = "/query";
		String param = "postid="+postid;
		url = url+query+"?"+param;
		return send(url);
	}
	
}
