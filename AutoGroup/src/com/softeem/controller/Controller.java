package com.softeem.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.dto.Group;
import com.softeem.dto.Student;
import com.softeem.jspsmart.upload.SmartUpload;
import com.softeem.jspsmart.upload.SmartUploadException;
import com.softeem.utils.Utils;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		String json = "";
		if("list".equals(type)){
			//学生列表
			String path = request.getSession().getServletContext().getRealPath("db/stus.json");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"utf-8"));
			StringBuffer buff = new StringBuffer();
			while((json = br.readLine()) != null){
				buff.append(json);
			}
			br.close();
			json = buff.toString();
			request.getSession().setAttribute("data", json);
		}else if("group".equals(type)){
			//分组
			String s = request.getParameter("num");
			int base = Integer.parseInt(s);
			json = request.getSession().getAttribute("data").toString();
			File file = new File("C:/Users/Administrator/Desktop/湖北二师项目分组.xls");
			System.out.println("文件生成成功:"+file.getAbsolutePath());
			if (!file.exists()) {
				file.createNewFile();
			}
			List<Student> stus = Utils.fromJson(json);
			List<Group> groups = Utils.group(stus, base);
			FileOutputStream fos = new FileOutputStream(file);
			Utils.genFile(groups, fos);
			json = Utils.toJson(groups);
			request.getSession().getServletContext().setAttribute("record", json);
			fos.close();
		}else if("stuPage".equals(type)){
			//学生端显示分组信息
			Object obj = request.getSession().getServletContext().getAttribute("record");
			if(obj != null){
				json = obj.toString();
			}
		}else if("download".equals(type)){
			try {
				SmartUpload su = new SmartUpload();
				su.initialize(this, request, response);
				su.setContentDisposition(null);
				su.downloadFile("C:/Users/Administrator/Desktop/湖北二师项目分组.xls");
				response.getOutputStream().close();
				return;
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
		}
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}

}
