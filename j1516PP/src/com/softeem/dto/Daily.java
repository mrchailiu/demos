package com.softeem.dto;

import java.sql.Timestamp;

public class Daily {

	private int id;
	private String name;	//姓名
	private String proName;	//项目名
	private int progress;	//进度
	private String detail;	//日报详情
	private Timestamp time;	//时间戳
	private String ip;		//日报发送人ip地址
	
	public Daily() {
	}
	
	public Daily(int id, String name, String proName, int progress,
			String detail, Timestamp time, String ip) {
		super();
		this.id = id;
		this.name = name;
		this.proName = proName;
		this.progress = progress;
		this.detail = detail;
		this.time = time;
		this.ip = ip;
	}

	public Daily(String name, String proName, int progress, String detail,
			Timestamp time, String ip) {
		super();
		this.name = name;
		this.proName = proName;
		this.progress = progress;
		this.detail = detail;
		this.time = time;
		this.ip = ip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
