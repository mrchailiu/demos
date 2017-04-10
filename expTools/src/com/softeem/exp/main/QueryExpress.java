package com.softeem.exp.main;


import com.softeem.exp.http.HttpRequest;
import com.softeem.exp.model.Summary;
import com.softeem.exp.utils.JsonUtils;

public class QueryExpress {

	/**
	 * 查询离线物流数据
	 * @param url		服务器地址
	 * @param postid	订单号
	 * @return
	 */
	public Summary[] queryOffline(String url,String postid){
		String json = HttpRequest.sendOffLine(url, postid);
		Summary[] sums = JsonUtils.getSums(json);
		return sums;
	}
	
	/**
	 * 查询在线物流数据
	 * @param url		服务器地址
	 * @param type		快递商代号
	 * @param postid	订单号
	 * @return
	 */
	public Summary[] queryOnline(String url,String type,String postid){
		String json = HttpRequest.sendOnLine(url, type, postid);
		return JsonUtils.getSums(json);
	}
}
