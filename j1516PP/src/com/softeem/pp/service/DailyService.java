package com.softeem.pp.service;

import java.util.List;

import com.softeem.dto.Daily;
import com.softeem.pp.config.Config;
import com.softeem.pp.dao.DailyDAO;

public class DailyService {

	private DailyDAO dao;
	
	public DailyService() {
		dao = new DailyDAO();
	}
	
	/**
	 * 完成日报发送
	 * @param daily
	 * @return
	 */
	public ServiceModel sendDaily(Daily daily){
		ServiceModel model = new ServiceModel();
		//寻找当前工程师最近一次提交的日报
		Daily latestDaily = dao.findLatest(daily.getName());
		
		//判断日报提交时间与上一次对比是否超过指定统计点小时(若小于指定统计点小时则说明不符合提交规定);如果最近一次提价日报为null则说明是第一次提交，直接通过
		if((latestDaily == null) ||(daily.getTime().getTime()-latestDaily.getTime().getTime() >= (1000L*60*60*Config.POINT))){
			//合理提交
			if(dao.save(daily)){
				model.setCode(1);
				model.setSuccess(true);
			}else{
				model.setCode(-1);
			}
		}
		return model;
	}
	
	/**
	 * 获取今日排行
	 * @return
	 */
	public ServiceModel getTodayList(){
		ServiceModel model = new ServiceModel();
		List list = dao.findToday();
		if(list.size() > 0){
			model.setCode(1);
			model.setSuccess(true);
			model.setData(list);
		}
		return model;
	}
	
	/**
	 * 获取总排行
	 * @return
	 */
	public ServiceModel getTotalList(){
		ServiceModel model = new ServiceModel();
		List list = dao.findTotalList();
		if(list.size() > 0){
			model.setCode(1);
			model.setSuccess(true);
			model.setData(list);
		}
		return model;
	}
}
