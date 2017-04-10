package com.softeem.pp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.softeem.dto.Daily;
import com.softeem.pp.service.DailyService;
import com.softeem.pp.service.ServiceModel;

public class DailyServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		ServiceModel model = null;
		
		if("send".equals(flag)){
			model = send(request,response);
		}else if("proList".equals(flag)){
			model = proList(request,response);
		}else if("totalList".equals(flag)){
			model = totalList(request,response);
		}
		//将serviceModel对象转换为json对象并发送到客户端
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String json = gson.toJson(model);
		out.print(json);
		out.flush();
	}

	/**
	 * 获取封装有总项目进度的列表数据
	 * @param request
	 * @param response
	 * @return
	 */
	private ServiceModel totalList(HttpServletRequest request,
			HttpServletResponse response) {
		DailyService service = new DailyService();
		ServiceModel model = service.getTotalList();
		model.setInfo(request.getRemoteAddr());//附加当前客户端ip地址
		return model;
	}


	/**
	 * 获取封装有今日项目进度的列表数据
	 * @param request
	 * @param response
	 * @return
	 */
	private ServiceModel proList(HttpServletRequest request,
			HttpServletResponse response) {
		DailyService service = new DailyService();
		ServiceModel model = service.getTodayList();
		model.setInfo(request.getRemoteAddr());//附加当前客户端ip地址
		return model;
	}


	/**
	 * 发送日报
	 * @param request
	 * @param response
	 * @return
	 */
	private ServiceModel send(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter("stuName");
		String proName = request.getParameter("proName");
		String progress = request.getParameter("progress");
		String detail = request.getParameter("detail");
		//获取系统时间 sql类型
		Timestamp now = new Timestamp(System.currentTimeMillis());
		String ip = request.getRemoteAddr();

		//构建日报对象
		Daily daily = new Daily(name, proName, Integer.parseInt(progress), detail, now, ip);
		DailyService service = new DailyService();
		//提交日报获取结果
		ServiceModel model = service.sendDaily(daily);
		
		return model;
	}

}
