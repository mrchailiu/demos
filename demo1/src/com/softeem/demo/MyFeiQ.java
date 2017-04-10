package com.softeem.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;//导包
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MyFeiQ {

	/**
	 * 飞秋客户端,向其他飞秋发送消息
	 * Socket编程(网络编程)
	 * UDP
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		MyFeiQ mq = new MyFeiQ();
		mq.sendMsg("192.168.0.100", "听说女寝被盗？究竟是人性的扭曲还是道德的沦丧！！！");
	}
	
	public void sendMsg(String ip,String msg) throws IOException {
		//准备货物(准备需要发送的数据)
		String data = "1:100:大郎:MRWestDoor:32:"+msg;
		//准备物流公司(创建一个网络通道)
		DatagramSocket ds = new DatagramSocket();
		//将货物打包，写上邮寄地址（将数据打包成数据报包）
		DatagramPacket dp = new DatagramPacket(
				data.getBytes(),				//将消息内容转换为字节数组
				0,							//数据发送的起始位置
				data.getBytes().length,		//数据发送的总长度
				InetAddress.getByName(ip),  //消息接收人的ip地址 
				2425		//飞秋的端口号
		);
		//物流公司发送包裹
		ds.send(dp);
	}

}
