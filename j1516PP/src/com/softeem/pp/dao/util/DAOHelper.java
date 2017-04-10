package com.softeem.pp.dao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.softeem.dbutil.DBConnection;

/**
 * ORM:�����ϵӳ��
 * @author Administrator
 *
 *SQL:�ṹ����ѯ����
 *NullPointerException �������/�ӿڵ�����/��������-->�������;���ָ��
 */
public class DAOHelper {
	
	private static Connection conn;
	private static PreparedStatement ps;

	//��װһ�������ܹ���������κα����ɾ�Ĳ���
	public static boolean executeUpdate(String sql,Object[] params){
		 try {
		    conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			if(params != null){
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			int i = ps.executeUpdate();
			if(i > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} 
	/*
	 * ����һ����ѯ�������
	 */
	public static Object query(String sql,Object[] params,CallBack callback){
		
		 try {
			    conn = DBConnection.getConn();
				ps = conn.prepareStatement(sql);
				//�����������Ϊnullʱ˵����Ҫִ�����ݵ�Ԥ����
				if(params != null){
					for (int i = 0; i < params.length; i++) {
						ps.setObject(i+1, params[i]);
					}
				}
				
				ResultSet rs = ps.executeQuery();
				return callback.getObject(rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return null;
	}
	
	/**
	 * ����һ����ѯ������󼯺�
	 * @param sql
	 * @param params
	 * @return
	 */
	public static List queryList(String sql,Object[] params,CallBack callback){
		 try {
			    conn = DBConnection.getConn();
				ps = conn.prepareStatement(sql);
			
				if(params != null){
					for (int i = 0; i < params.length; i++) {
						ps.setObject(i+1, params[i]);
					}
				}
					
				ResultSet rs = ps.executeQuery();
				return callback.getList(rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return null;
	}
	
	public static ResultSet getResults(String sql,Object[] params){
		try {
			conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			if(params != null){
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
