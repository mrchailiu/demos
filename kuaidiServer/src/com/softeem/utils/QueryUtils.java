package com.softeem.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.softeem.dto.ExpInfo;
import com.softeem.dto.ExpressModel;
import com.softeem.dto.Summary;

public class QueryUtils {

	public static String getModels(int type,String json,String postid){
		ExpressModel model = null;
			if(type == 0){
				//离线数据
				List<ExpInfo> list = JsonUtils.getObjs(json);
				for (int i = 0; i < list.size(); i++) {
					String pid = list.get(i).getPostid();
					if(pid.equals(postid)){
						model = list.get(i).getContent();
						break;
					}
				}
			}else if(type == 1){
				//在线数据
				model = JsonUtils.getObj(json);
			}
			
			if(model != null){
				Summary[] sums = model.getData();
				return JsonUtils.getJSON(sums);
			}else{
				return "error";
			}
	}
}
