package com.softeem.dto;

import java.util.ArrayList;
import java.util.List;

public class Group {

	private int gid;	//����id
	private String name;//������
	private List<Student> stus = new ArrayList<Student>();
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStus() {
		return stus;
	}
	public void setStus(List<Student> stus) {
		this.stus = stus;
	}
	
}
