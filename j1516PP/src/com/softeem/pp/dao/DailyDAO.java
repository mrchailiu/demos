package com.softeem.pp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.softeem.dto.Daily;
import com.softeem.pp.config.Config;
import com.softeem.pp.dao.util.CallBack;
import com.softeem.pp.dao.util.DAOHelper;

public class DailyDAO {
	
	/**
	 * ���������������һ�ε��ձ�
	 * @param name
	 * @return
	 */
	public Daily findLatest(String name){
		Daily daily = null;
		String sql = "select top 1 * from daily where name=? order by time desc;";
		Object obj = DAOHelper.query(sql, new Object[]{name}, new CallBack() {
			//��ѯ���ؽ����Ψһ������ֻ��ʵ��getObject��������
			public Object getObject(ResultSet rs) {
				Daily daily = null;
				try {
					if(rs.next()){
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String proName = rs.getString("proName");
						int progress = rs.getInt("progress");
						String ip = rs.getString("ip");
						Timestamp time = rs.getTimestamp("time");
						String detail = rs.getString("detail");
						daily = new Daily(id,name, proName, progress, detail, time, ip);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return daily;
			}
			
			public List getList(ResultSet rs) {
				return null;
			}
		});
		if(obj != null){
			daily = (Daily)obj;
		}
		return daily;
	}
	
	/**
	 * ����ձ�
	 * @param daily
	 * @return
	 */
	public boolean save(Daily daily){
		String sql = "insert into daily(name,proName,progress,time,ip,detail) values(?,?,?,?,?,?)";
		return DAOHelper.executeUpdate(sql, new Object[]{
				daily.getName(),
				daily.getProName(),
				daily.getProgress(),
				daily.getTime(),
				daily.getIp(),
				daily.getDetail()});
	}
	
	/**
	 * ��ѯ���������ձ�,�������ɸߵ�����ʾ(ȥ���ظ�)
	 * @return
	 */
	public List findToday(){
		
		String sql = "select d.* from daily d,(select name,MAX(progress) p,MAX(id) id "+
		"from daily where DATEDIFF(HH,time,GETDATE())<="+Config.POINT+" group by name) t "+
		"where d.name=t.name and d.progress=t.p and d.id=t.id order by d.progress desc";
		
		return DAOHelper.queryList(sql, null, new CallBack() {
			
			public Object getObject(ResultSet rs) {
				return null;
			}
			//���ؽ��Ϊ��������
			public List getList(ResultSet rs) {
				List list = new ArrayList();
				Daily daily = null;
				try {
					while(rs.next()){
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String proName = rs.getString("proName");
						int progress = rs.getInt("progress");
						String ip = rs.getString("ip");
						Timestamp time = rs.getTimestamp("time");
						String detail = rs.getString("detail");
						daily = new Daily(id,name, proName, progress, detail, time, ip);
						list.add(daily);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}
	
	/**
	 * ��ѯ�ܽ�������(ȥ���ظ�:ȡ�������ֵ)
	 * @return
	 */
	public List findTotalList(){
		
//		String sql = "select d.* from daily d," +
//				"(select distinct MAX(progress) p,name,MAX(id) id from daily " +
//				"group by name) t " +
//				"where d.name=t.name and " +
//				"d.progress=t.p and d.id=t.id order by d.progress desc";
		String sql = "select MAX(progress) p,name n,MAX(id) id from daily group by name order by p desc";
		
		return DAOHelper.queryList(sql, null, new CallBack() {
			
			public Object getObject(ResultSet rs) {
				return null;
			}
			
			public List getList(ResultSet rs) {
				List list = new ArrayList();
				Daily daily = null;
				try {
					while(rs.next()){
						int id = rs.getInt("id");
						String name = rs.getString("n");
//						String proName = rs.getString("proName");
						int progress = rs.getInt("p");
//						String ip = rs.getString("ip");
//						Timestamp time = rs.getTimestamp("time");
//						String detail = rs.getString("detail");
						daily = new Daily(id,name, null, progress, null, null, null);
						list.add(daily);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}
	
	/**
	 * ����id��ѯ�ձ�����
	 * @param id
	 * @return
	 */
	public Daily findById(int id)
	{
		return null;
	}
	
}
