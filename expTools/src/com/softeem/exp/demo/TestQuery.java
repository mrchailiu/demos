package com.softeem.exp.demo;

import com.softeem.exp.main.QueryExpress;
import com.softeem.exp.model.Summary;

public class TestQuery {

	//≤‚ ‘
	public static void main(String[] args) {
		QueryExpress query = new QueryExpress();
		//¿Îœﬂ≤È—Ø
//		Summary[] sums = query.queryOffline("http://127.0.0.1:8080/kuaidi", "778794234699");
		Summary[] sums = query.queryOnline("http://127.0.0.1:8080/kuaidi","zhongtong","778794234699");
		
		for (Summary s : sums) {
			String data = s.getContext();
			String time = s.getTime();
			System.out.println(time+"----"+data);
		}
	
	}
}
