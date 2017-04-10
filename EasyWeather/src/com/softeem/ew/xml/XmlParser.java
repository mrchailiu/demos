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
 * xml数据的解析工具类
 * @author Administrator
 *
 */
public class XmlParser {
	
	private DocumentBuilder builder;
	
	public XmlParser() throws ParserConfigurationException {
		builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	}

	/**
	 * 将指定的输入流解析为对应的Java对象
	 * @param is	包含天气数据输入流
	 * @return		返回解析获取的所有城市天气对象
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public List<City> getCities(InputStream is) throws SAXException, IOException{
		List<City> cities = new ArrayList<City>();
		Document document = builder.parse(is);
		//获取所有的city元素
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
			int tem1 = Integer.parseInt(element.getAttribute("tem1"));//最高温
			int tem2 = Integer.parseInt(element.getAttribute("tem2"));//最低温
			String tn = element.getAttribute("temNow");
			//获取当前温度，如果没有当前温度(省级别天气)则使用-10000代表无数据
			int temNow = (tn != null && !"暂无实况".equals(tn) && !"".equals(tn))?Integer.parseInt(tn):-10000;
			//根据获取的数据创建city对象
			City city = new City(quName, pyName, cityName, state1, state2, stateDetailed, windState, windDir, windPower, humidity, lastTime, tem1, tem2, temNow);
			cities.add(city);
		}
		return cities;
	}
}
