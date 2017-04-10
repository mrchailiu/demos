package com.softeem.dto;

import java.util.Arrays;

public class ExpressModel {

	private String message;
	private String nu;		//����
	private int isCheck;	
	private String com;		//��ݹ�˾���
	private int status;		//״̬��
	private String condition;	
	private int state;		
	private Summary[] data;	//����
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNu() {
		return nu;
	}
	public void setNu(String nu) {
		this.nu = nu;
	}
	public int getIsCheck() {
		return isCheck;
	}
	public void setIsCheck(int isCheck) {
		this.isCheck = isCheck;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Summary[] getData() {
		return data;
	}
	public void setData(Summary[] data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ExpressModel [com=" + com + ", condition=" + condition
				+ ", data=" + Arrays.toString(data) + ", isCheck=" + isCheck
				+ ", message=" + message + ", nu=" + nu + ", state=" + state
				+ ", status=" + status + "]";
	}

}
