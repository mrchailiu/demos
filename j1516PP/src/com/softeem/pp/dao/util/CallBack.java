package com.softeem.pp.dao.util;

import java.sql.ResultSet;
import java.util.List;

public interface CallBack {

	public Object getObject(ResultSet rs);
	
	public List getList(ResultSet rs);
}
