package com.softeem.exp.model;

public class ExpInfo {

	private String postid;		//µ•∫≈
	private ExpressModel content;	//œÍ«È
	
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public ExpressModel getContent() {
		return content;
	}
	public void setContent(ExpressModel content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ExpInfo [content=" + content + ", postid=" + postid + "]";
	}
	
}
