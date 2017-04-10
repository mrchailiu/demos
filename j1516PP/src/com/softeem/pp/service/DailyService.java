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
	 * ����ձ�����
	 * @param daily
	 * @return
	 */
	public ServiceModel sendDaily(Daily daily){
		ServiceModel model = new ServiceModel();
		//Ѱ�ҵ�ǰ����ʦ���һ���ύ���ձ�
		Daily latestDaily = dao.findLatest(daily.getName());
		
		//�ж��ձ��ύʱ������һ�ζԱ��Ƿ񳬹�ָ��ͳ�Ƶ�Сʱ(��С��ָ��ͳ�Ƶ�Сʱ��˵���������ύ�涨);������һ������ձ�Ϊnull��˵���ǵ�һ���ύ��ֱ��ͨ��
		if((latestDaily == null) ||(daily.getTime().getTime()-latestDaily.getTime().getTime() >= (1000L*60*60*Config.POINT))){
			//�����ύ
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
	 * ��ȡ��������
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
	 * ��ȡ������
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
