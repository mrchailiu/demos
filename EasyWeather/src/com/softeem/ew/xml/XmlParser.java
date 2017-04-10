package com.softeem.ew.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.softeem.ew.dto.City;

/**
 * xml���ݵĽ���������
 * @author Administrator
 *
 */
public class XmlParser {
	
	private DocumentBuilder builder;
	
	public XmlParser() throws ParserConfigurationException {
		builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	}

	/**
	 * ��ָ��������������Ϊ��Ӧ��Java����
	 * @param is	������������������
	 * @return		���ؽ�����ȡ�����г�����������
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public List<City> getCities(InputStream is) throws SAXException, IOException{
		List<City> cities = new ArrayList<City>();
		Document document = builder.parse(is);
		//��ȡ���е�cityԪ��
		NodeList list = document.getElementsByTagName("city");
		for (int i = 0; i < list.getLength(); i++) {
			Element element = (Element)list.item(i);
			String quName = element.getAttribute("quName");
			String pyName = element.getAttribute("pyName");
			String cityName = element.getAttribute("cityname");
			String state1 = element.getAttribute("state1");
			String state2 = element.getAttribute("state2");
			String stateDetailed = element.getAttribute("stateDetailed");
			String windState = element.getAttribute("windState");
			String windDir = element.getAttribute("windDir");
			String windPower = element.getAttribute("windPower");
			String humidity = element.getAttribute("humidity");
			String lastTime = element.getAttribute("time");
			int tem1 = Integer.parseInt(element.getAttribute("tem1"));//�����
			int tem2 = Integer.parseInt(element.getAttribute("tem2"));//�����
			String tn = element.getAttribute("temNow");
			//��ȡ��ǰ�¶ȣ����û�е�ǰ�¶�(ʡ��������)��ʹ��-10000����������
			int temNow = (tn != null && !"����ʵ��".equals(tn) && !"".equals(tn))?Integer.parseInt(tn):-10000;
			//���ݻ�ȡ�����ݴ���city����
			City city = new City(quName, pyName, cityName, state1, state2, stateDetailed, windState, windDir, windPower, humidity, lastTime, tem1, tem2, temNow);
			cities.add(city);
		}
		return cities;
	}
}
