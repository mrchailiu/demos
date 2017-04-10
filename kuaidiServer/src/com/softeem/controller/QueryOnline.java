package com.softeem.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.dto.ExpCode;
import com.softeem.dto.ExpressModel;
import com.softeem.http.Constant;
import com.softeem.http.HttpReq;
import com.softeem.utils.JsonUtils;
import com.softeem.utils.QueryUtils;
import com.softeem.utils.XmlParseUtils;

/**
 * ���߲�ѯ���ṩ��ݵ��ţ�����̴��룩
 * @author Administrator
 */
public class QueryOnline extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//��ȡ���źͿ�����ʹ���
		String postid = request.getParameter("postid");
		String type = request.getParameter("type");
		String json = "";
		
		if(type != null){
			//���ӽӿ��ṩ�̻�ȡjson����
			String url = Constant.HTTP_URL+"?type="+type+"&postid="+postid+"&t="+System.currentTimeMillis()+Math.random();
			json = HttpReq.request(url);
			json = QueryUtils.getModels(1, json, postid);
			System.out.println("server---url>>"+url);
			System.out.println("server---json>>"+json);
		}else{
			//���ؿ�ݹ�˾��Ϣ
			File file = new File(request.getSession().getServletContext().getRealPath("expCode.xml"));
			XmlParseUtils parse = new XmlParseUtils(file);
			List<ExpCode> codes = parse.getData();
			json = JsonUtils.getJSON(codes);
		}
		out.print(json);
		out.flush();
	}

}
