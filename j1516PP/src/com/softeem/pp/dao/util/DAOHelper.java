package com.softeem.pp.dao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.softeem.dbutil.DBConnection;

/**
 * ORM:对象关系映射
 * @author Administrator
 *
 *SQL:结构化查询语言
 *NullPointerException 类的引用/接口的引用/数组引用-->引用类型就是指针
 */
public class DAOHelper {
	
	private static Connection conn;
	private static PreparedStatement ps;

	//封装一个方法能够解决对于任何表的增删改操作
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
	 * 返回一个查询结果对象
	 */
	public static Object query(String sql,Object[] params,CallBack callback){
		
		 try {
			    conn = DBConnection.getConn();
				ps = conn.prepareStatement(sql);
				//当输入参数不为null时说明需要执行数据的预处理
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
	 * 返回一个查询结果对象集合
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
