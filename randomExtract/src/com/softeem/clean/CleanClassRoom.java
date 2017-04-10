package com.softeem.clean;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class CleanClassRoom {
	
	public Map<String,String> parse(String path){
		//定义一个Map集合,用来存放学生Id以及对应的姓名(name)
		Map<String,String> map = new HashMap();
		//创建一个SAXReader对象
		SAXReader reader = new SAXReader();
		try {
			//获取到需要解析的文档
			Document doc = reader.read(new File(path));
			//取得该xml文档的根节点
			Element root = doc.getRootElement();
			//获得student节点的迭代集合
			Iterator it = root.elementIterator("student");
			//循环遍历该集合
			while(it.hasNext()){
				//返回该元素对象
				Element student = (Element)it.next();
				//获取student节点中id属性值
				String id = student.attributeValue("id");
			//	System.out.println(id+"!!!!!!!!");
				//获取student节点中文本name的值
				String name = student.elementText("name");
			//	System.out.println(name+"!!!!!!!!");
				//将student节点中的id,name以键值对的形式存放到map集合中
				map.put(id, name);
			}
			//System.out.println(map);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}
	
	public List<String> getStudent(String path){
		//取得map对象
		Map<String,String> map = parse(path);
		//创建一个Random对象
		Random r = new Random();
		//定义一个集合用于存放map中的value
		List<String> list = new ArrayList<String>();
		//定义另一个集合用于存放随机抽取出的student对象的name值
		List<String> list2 = new ArrayList<String>();
		//获取map中键的set集合(唯一性)
 		Set<String> set = map.keySet();
 		//获得一个迭代器
		Iterator it = set.iterator();
		//将set集合中的内容迭代输出
		while(it.hasNext()){
			//取得set中的值(id)
			String no = (String)it.next();
			//通过id对应取得到name(K-->V)
			String name = map.get(no);
			//将name存放到list中
			list.add(name);
		}
		//循环四次对应需要四个结果
		for(int i=0;i<4;i++){
				//随机获取到对应的元素下标
				int k = r.nextInt(list.size());
				//取得下标对应的值
				String str = list.get(k);
				//为了防止取得元素重复,这里需要将每次取出的元素移除
				list.remove(k);
				//将取得的name存放进第二个list中
				list2.add(str);
		
		}
		
		return list2;
	}

}
