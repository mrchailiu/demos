package com.softeem.pp.service;

public class ServiceModel {

	private int code;//״̬��    1:�ɹ�		0:�ձ��ύ����Ƶ��(�涨ʱ����)	-1:���ݿ��쳣(����Ϊ�ύ���ݲ��Ϲ淶)
	private boolean isSuccess;//���
	private String info;//����
	private Object data;//����
	
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
