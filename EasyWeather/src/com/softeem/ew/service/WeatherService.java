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
 * 处理天气数据的业务逻辑层
 * @author Administrator
 *
 */
public class WeatherService {

	/**
	 * 查询指定城市下所有的地区天气
	 * @param pyName
	 * @return
	 */
	public List<City> getCitiesWeather(String pyName){
		InputStream is = null;
		List<City> cities = null;
		try {
			//拼接获取请求地址
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
	 * 查询指定某个城市或地区的天气情况
	 * @param pyName
	 * @param cityName
	 * @return
	 */
	public City getCityWeather(String pyName,String cityName){
		InputStream is = null;
		List<City> cities = null;
		City city = null;
		try {
			//拼接获取请求地址
			String uri = Constant.BASE_URI+pyName+".xml";
			is = HttpRequest.read(uri);
			XmlParser parser = new XmlParser();
			cities = parser.getCities(is);
			for (City c : cities) {
				//判断当前遍历到的城市名字是否是需要被查询的城市名字
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
