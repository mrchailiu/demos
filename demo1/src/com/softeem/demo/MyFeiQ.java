package com.softeem.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;//����
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MyFeiQ {

	/**
	 * ����ͻ���,���������﷢����Ϣ
	 * Socket���(������)
	 * UDP
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		MyFeiQ mq = new MyFeiQ();
		mq.sendMsg("192.168.0.100", "��˵Ů�ޱ��������������Ե�Ť�����ǵ��µ���ɥ������");
	}
	
	public void sendMsg(String ip,String msg) throws IOException {
		//׼������(׼����Ҫ���͵�����)
		String data = "1:100:����:MRWestDoor:32:"+msg;
		//׼��������˾(����һ������ͨ��)
		DatagramSocket ds = new DatagramSocket();
		//����������д���ʼĵ�ַ�������ݴ�������ݱ�����
		DatagramPacket dp = new DatagramPacket(
				data.getBytes(),				//����Ϣ����ת��Ϊ�ֽ�����
				0,							//���ݷ��͵���ʼλ��
				data.getBytes().length,		//���ݷ��͵��ܳ���
				InetAddress.getByName(ip),  //��Ϣ�����˵�ip��ַ 
				2425		//����Ķ˿ں�
		);
		//������˾���Ͱ���
		ds.send(dp);
	}

}
