package com.softeem.utils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.softeem.dto.Group;
import com.softeem.dto.Student;

public class Utils {

	public static String toJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

	public static List<Student> fromJson(String json) {
		Gson gson = new Gson();
		List<Student> students = gson.fromJson(json,
				new TypeToken<List<Student>>() {
				}.getType());
		return students;
	}

	public static List<Group> group(List<Student> stus, int base) {
		List<Group> groups = new ArrayList<Group>();
		// 随机置换
		Collections.shuffle(stus);
		Collections.shuffle(stus);
		Collections.shuffle(stus);

		int groupCount = 0;
		// 计算分组数
		if (stus.size() % base == 0) {
			groupCount = stus.size() / base;
		} else {
			groupCount = stus.size() / base + 1;
		}
		Iterator<Student> students = stus.iterator();
		for (int i = 0; i < groupCount; i++) {
			Group g = new Group();
			while (students.hasNext()) {
				if (g.getStus().size() < base) {
					Student stu = students.next();
					g.getStus().add(stu);// 添加到分组
					students.remove();// 移出该项
				} else {
					break;
				}
			}
			// 添加到集合中
			groups.add(g);
		}
		return groups;
	}

	// 生成文件
	public static void genFile(List<Group> groups, OutputStream os)
			throws IOException {
		
		WritableWorkbook book = Workbook.createWorkbook(os);
		WritableSheet sheet = book.createSheet("sheet1", 0);
		try {
			Label label_1 = new Label(0, 0, "姓名");
			Label label_2 = new Label(1, 0, "性别");
			Label label_3 = new Label(2, 0, "专业");
			Label label_4 = new Label(3, 0, "组名");
			sheet.addCell(label_1);
			sheet.addCell(label_2);
			sheet.addCell(label_3);
			sheet.addCell(label_4);
			
			int n = 1;
			WritableFont font = new WritableFont(WritableFont.createFont("宋体"),  
                      15,   
                      WritableFont.NO_BOLD,   
                      false,  
                      UnderlineStyle.NO_UNDERLINE); 

			for (int i = 0; i < groups.size(); i++) {
				WritableCellFormat fmt = new WritableCellFormat(font);
				if(i % 2 == 0){
					fmt.setBackground(Colour.LIGHT_ORANGE);
				}else{
					fmt.setBackground(Colour.LIGHT_BLUE);
				}
				for (int j = 0; j < groups.get(i).getStus().size(); j++) {
					label_1 = new Label(0, n, groups.get(i).getStus().get(j).getName());
					label_2 = new Label(1, n, groups.get(i).getStus().get(j).getSex());
					label_3 = new Label(2, n, groups.get(i).getStus().get(j).getMajor());
					label_4 = new Label(3, n, "第" + (i + 1) + "组");
					label_1.setCellFormat(fmt);
					label_2.setCellFormat(fmt);
					label_3.setCellFormat(fmt);
					label_4.setCellFormat(fmt);
					sheet.addCell(label_1);
					sheet.addCell(label_2);
					sheet.addCell(label_3);
					sheet.addCell(label_4);
					n++;
				}
			}
			book.write();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} finally {
			try {
				book.close();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
	}
}
