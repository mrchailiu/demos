package com.softeem.ew.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.softeem.ew.dto.City;
import com.softeem.ew.http.Constant;
import com.softeem.ew.http.HttpRequest;
import com.softeem.ew.xml.XmlParser;

/**
 * �����������ݵ�ҵ���߼���
 * @author Administrator
 *
 */
public class WeatherService {

	/**
	 * ��ѯָ�����������еĵ�������
	 * @param pyName
	 * @return
	 */
	public List<City> getCitiesWeather(String pyName){
		InputStream is = null;
		List<City> cities = null;
		try {
			//ƴ�ӻ�ȡ�����ַ
			String uri = Constant.BASE_URI+pyName+".xml";
			is = HttpRequest.read(uri);
			XmlParser parser = new XmlParser();
			cities = parser.getCities(is);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}finally{
				try {
					if(is != null)
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return cities;
	}
	/**
	 * ��ѯָ��ĳ�����л�������������
	 * @param pyName
	 * @param cityName
	 * @return
	 */
	public City getCityWeather(String pyName,String cityName){
		InputStream is = null;
		List<City> cities = null;
		City city = null;
		try {
			//ƴ�ӻ�ȡ�����ַ
			String uri = Constant.BASE_URI+pyName+".xml";
			is = HttpRequest.read(uri);
			XmlParser parser = new XmlParser();
			cities = parser.getCities(is);
			for (City c : cities) {
				//�жϵ�ǰ�������ĳ��������Ƿ�����Ҫ����ѯ�ĳ�������
				if(c.getCityName().equals(cityName)){
					city = c;
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(is != null)
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return city;
	}
	
}
