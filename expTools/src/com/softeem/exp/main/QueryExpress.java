package com.softeem.exp.main;


import com.softeem.exp.http.HttpRequest;
import com.softeem.exp.model.Summary;
import com.softeem.exp.utils.JsonUtils;

public class QueryExpress {

	/**
	 * ��ѯ������������
	 * @param url		��������ַ
	 * @param postid	������
	 * @return
	 */
	public Summary[] queryOffline(String url,String postid){
		String json = HttpRequest.sendOffLine(url, postid);
		Summary[] sums = JsonUtils.getSums(json);
		return sums;
	}
	
	/**
	 * ��ѯ������������
	 * @param url		��������ַ
	 * @param type		����̴���
	 * @param postid	������
	 * @return
	 */
	public Summary[] queryOnline(String url,String type,String postid){
		String json = HttpRequest.sendOnLine(url, type, postid);
		return JsonUtils.getSums(json);
	}
}
