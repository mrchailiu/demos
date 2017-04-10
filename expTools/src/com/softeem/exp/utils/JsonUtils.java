package com.softeem.exp.utils;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.softeem.exp.model.ExpInfo;
import com.softeem.exp.model.ExpressModel;
import com.softeem.exp.model.Summary;

public class JsonUtils {

	//������ת��Ϊjson�ַ��� 
	public static String getJSON(Object obj){
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	//��json�ַ�������Ϊ������Ϣ
	public static List<ExpInfo> getObjs(String json){
		System.out.println("��������---->"+json);
		Gson gson = new Gson();
		List<ExpInfo> expInfo = gson.fromJson(json, new TypeToken<List<ExpInfo>>(){}.getType());
		return expInfo;
	}
	//��json�ַ�������Ϊ�������� 
	public static ExpressModel getObj(String json){
		System.out.println("��������---->"+json);
		Gson gson = new Gson();
		ExpressModel em = gson.fromJson(json, ExpressModel.class);
		return em;
	}
	
	//��ȡ��������
	public static Summary[] getSums(String json){
		System.out.println("��������---->"+json);
		Gson gson = new Gson();
		Summary[] sums = gson.fromJson(json, new TypeToken<Summary[]>(){}.getType());
		return sums;
	}
}
