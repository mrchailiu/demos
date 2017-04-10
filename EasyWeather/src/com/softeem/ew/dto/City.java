package com.softeem.ew.dto;
/**
 * 描述城市天气详情的javabean
 * @author Administrator
 */
public class City {
	
	private String quName;			//地区名称
	private String pyName;			//下一级查询的文件名(下一级地区拼音名)
	private String cityName;		//城市名字
	private String state1;			//天气状态1（对应天气图片名1）
	private String state2;			//天气状态2（对应天气图片名2）
	private String stateDetailed;	//天气详情
	private String windState;		//风力情况
	private String windDir;			//风向
	private String windPower;		//风力级别
	private String humidity;		//湿度
	private String lastTime;		//最近一次更新时间
	private int tem1;				//最高温度
	private int tem2;				//最低温度
	private int temNow;				//当前温度
	
	public City() {
		// TODO Auto-generated constructor stub
	}

	public City(String quName, String pyName, String cityName, String state1,
			String state2, String stateDetailed, String windState,
			String windDir, String windPower, String humidity, String lastTime,
			int tem1, int tem2, int temNow) {
		super();
		this.quName = quName;
		this.pyName = pyName;
		this.cityName = cityName;
		this.state1 = state1;
		this.state2 = state2;
		this.stateDetailed = stateDetailed;
		this.windState = windState;
		this.windDir = windDir;
		this.windPower = windPower;
		this.humidity = humidity;
		this.lastTime = lastTime;
		this.tem1 = tem1;
		this.tem2 = tem2;
		this.temNow = temNow;
	}

	public String getQuName() {
		return quName;
	}

	public void setQuName(String quName) {
		this.quName = quName;
	}

	public String getPyName() {
		return pyName;
	}

	public void setPyName(String pyName) {
		this.pyName = pyName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getState1() {
		return state1;
	}

	public void setState1(String state1) {
		this.state1 = state1;
	}

	public String getState2() {
		return state2;
	}

	public void setState2(String state2) {
		this.state2 = state2;
	}

	public String getStateDetailed() {
		return stateDetailed;
	}

	public void setStateDetailed(String stateDetailed) {
		this.stateDetailed = stateDetailed;
	}

	public String getWindState() {
		return windState;
	}

	public void setWindState(String windState) {
		this.windState = windState;
	}

	public String getWindDir() {
		return windDir;
	}

	public void setWindDir(String windDir) {
		this.windDir = windDir;
	}

	public String getWindPower() {
		return windPower;
	}

	public void setWindPower(String windPower) {
		this.windPower = windPower;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public int getTem1() {
		return tem1;
	}

	public void setTem1(int tem1) {
		this.tem1 = tem1;
	}

	public int getTem2() {
		return tem2;
	}

	public void setTem2(int tem2) {
		this.tem2 = tem2;
	}

	public int getTemNow() {
		return temNow;
	}

	public void setTemNow(int temNow) {
		this.temNow = temNow;
	}

	@Override
	public String toString() {
		return "City [cityName=" + cityName + ", humidity=" + humidity
				+ ", lastTime=" + lastTime + ", pyName=" + pyName + ", quName="
				+ quName + ", state1=" + state1 + ", state2=" + state2
				+ ", stateDetailed=" + stateDetailed + ", tem1=" + tem1
				+ ", tem2=" + tem2 + ", temNow=" + temNow + ", windDir="
				+ windDir + ", windPower=" + windPower + ", windState="
				+ windState + "]";
	}
}
