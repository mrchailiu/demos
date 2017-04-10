package com.softeem.ew.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.ew.dto.City;
import com.softeem.ew.http.Constant;
import com.softeem.ew.service.WeatherService;

//MVC:ģ�� ��ͼ ������		
//����ṹ�� ��ͼ ҵ���߼� ���ݲ�
public class WeatherController extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getSession().setAttribute("imgPath", Constant.BASE_IMG_URI);
		String flag = request.getParameter("flag");
		if("details".equals(flag)){
			details(request,response);//��ʾ��������
		}else{
			list(request, response);
		}
		
	
	}

	private void details(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pyName = request.getParameter("pyName");
		String cityName = request.getParameter("cityName");
		WeatherService service = new WeatherService();
		City city = service.getCityWeather(pyName, cityName);
		System.out.println("---->"+city);
		request.setAttribute("city", city);
		request.getRequestDispatcher("details.jsp").forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pyName = request.getParameter("pyName");
		pyName = pyName != null?pyName:"china";
		WeatherService service = new WeatherService();
		List<City> cities = service.getCitiesWeather(pyName);
		//�������ݵ�ǰ��ѯ�ĳ��м��϶�Ӧ��pyName
		request.setAttribute("pyName", pyName);
		request.setAttribute("cities", cities);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	

}
