package com.softeem.dto;

public class Student {

	private int sid;	 //id
	private String name;//����
	private String sex;	 //�Ա�
	private String major;//רҵ
	private String pen;	//�²�
	private double score;//����
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getPen() {
		return pen;
	}
	public void setPen(String pen) {
		this.pen = pen;
	}
	
}
