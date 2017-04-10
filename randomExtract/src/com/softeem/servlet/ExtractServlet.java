package com.softeem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.clean.CleanClassRoom;

public class ExtractServlet extends HttpServlet {


	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = this.getInitParameter("path");
		List<String> list = new CleanClassRoom().getStudent(path);
		request.setAttribute("list", list);
		System.out.println(list.get(1)+"!!!!!!!!!");
		request.setAttribute("msg", "congratulations!");
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	


}
