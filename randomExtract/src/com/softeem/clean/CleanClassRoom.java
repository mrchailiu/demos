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
		//����һ��Map����,�������ѧ��Id�Լ���Ӧ������(name)
		Map<String,String> map = new HashMap();
		//����һ��SAXReader����
		SAXReader reader = new SAXReader();
		try {
			//��ȡ����Ҫ�������ĵ�
			Document doc = reader.read(new File(path));
			//ȡ�ø�xml�ĵ��ĸ��ڵ�
			Element root = doc.getRootElement();
			//���student�ڵ�ĵ�������
			Iterator it = root.elementIterator("student");
			//ѭ�������ü���
			while(it.hasNext()){
				//���ظ�Ԫ�ض���
				Element student = (Element)it.next();
				//��ȡstudent�ڵ���id����ֵ
				String id = student.attributeValue("id");
			//	System.out.println(id+"!!!!!!!!");
				//��ȡstudent�ڵ����ı�name��ֵ
				String name = student.elementText("name");
			//	System.out.println(name+"!!!!!!!!");
				//��student�ڵ��е�id,name�Լ�ֵ�Ե���ʽ��ŵ�map������
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
		//ȡ��map����
		Map<String,String> map = parse(path);
		//����һ��Random����
		Random r = new Random();
		//����һ���������ڴ��map�е�value
		List<String> list = new ArrayList<String>();
		//������һ���������ڴ�������ȡ����student�����nameֵ
		List<String> list2 = new ArrayList<String>();
		//��ȡmap�м���set����(Ψһ��)
 		Set<String> set = map.keySet();
 		//���һ��������
		Iterator it = set.iterator();
		//��set�����е����ݵ������
		while(it.hasNext()){
			//ȡ��set�е�ֵ(id)
			String no = (String)it.next();
			//ͨ��id��Ӧȡ�õ�name(K-->V)
			String name = map.get(no);
			//��name��ŵ�list��
			list.add(name);
		}
		//ѭ���Ĵζ�Ӧ��Ҫ�ĸ����
		for(int i=0;i<4;i++){
				//�����ȡ����Ӧ��Ԫ���±�
				int k = r.nextInt(list.size());
				//ȡ���±��Ӧ��ֵ
				String str = list.get(k);
				//Ϊ�˷�ֹȡ��Ԫ���ظ�,������Ҫ��ÿ��ȡ����Ԫ���Ƴ�
				list.remove(k);
				//��ȡ�õ�name��Ž��ڶ���list��
				list2.add(str);
		
		}
		
		return list2;
	}

}
