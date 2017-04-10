package com.softeem.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.dto.ExpInfo;
import com.softeem.dto.ExpressModel;
import com.softeem.dto.Summary;
import com.softeem.utils.JsonUtils;
import com.softeem.utils.QueryUtils;

/**
 * 离线查询(固定数据)
 * @author Administrator
 */
public class QueryLocale extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String postid = request.getParameter("postid");
			System.out.println(postid+"########");
			File file = new File(request.getSession().getServletContext().getRealPath("/data.json"));
			BufferedReader br = new BufferedReader(new FileReader(file));
			StringBuffer buff = new StringBuffer();
			String str = "";
			while((str = br.readLine()) != null){
				buff.append(str);
			}
			br.close();
			str = buff.toString();
			
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			//离线数据
			String json = QueryUtils.getModels(0,str, postid);
			
			System.out.println(json+"###");
			out.print(json);
			out.flush();
	}

}
