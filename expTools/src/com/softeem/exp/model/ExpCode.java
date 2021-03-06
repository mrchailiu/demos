package com.softeem.exp.model;

/**
 * 物流公司详情
 * @author Administrator
 *
 */
public class ExpCode {

	private String code;
	private String name;
	
	public ExpCode() {
		// TODO Auto-generated constructor stub
	}
	
	public ExpCode(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ExpCode [code=" + code + ", name=" + name + "]";
	}
	
}
