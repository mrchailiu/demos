package com.softeem.pp.service;

public class ServiceModel {

	private int code;//状态码    1:成功		0:日报提交过于频繁(规定时间间隔)	-1:数据库异常(可能为提交数据不合规范)
	private boolean isSuccess;//结果
	private String info;//详情
	private Object data;//数据
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
