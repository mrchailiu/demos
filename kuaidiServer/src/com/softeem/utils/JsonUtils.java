package com.softeem.utils;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.softeem.dto.ExpInfo;
import com.softeem.dto.ExpressModel;

public class JsonUtils {

	//将对象转换为json字符串
	public static String getJSON(Object obj){
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	//将json字符串解析为物流信息集合
	public static List<ExpInfo> getObjs(String json){
		Gson gson = new Gson();
		List<ExpInfo> expInfo = gson.fromJson(json, new TypeToken<List<ExpInfo>>(){}.getType());
		return expInfo;
	}
	//将json字符串解析为物流对象 
	public static ExpressModel getObj(String json){
		Gson gson = new Gson();
		ExpressModel em = gson.fromJson(json, ExpressModel.class);
		return em;
	}
}
