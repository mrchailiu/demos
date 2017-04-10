package com.softeem.demo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//�������:��װ���̳У���̬
public class MyFrame extends JFrame{

	public MyFrame(){
		this.setSize(500,400);	//���ô����С(��ȣ��߶�)
		this.setTitle("��������..."); //���ñ���
		this.setResizable(false);	//��ֹ�ı䴰���С
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����Ĭ�ϵĹر�ѡ��(������ر������Զ��ر�)
		this.setLocationRelativeTo(null);//���ô���Ĭ������Ļ���м�
		//�������뵽������
		this.add(new MyPanel());
		this.setVisible(true);	//���ô���ɼ�
	}
	//�����
	class MyPanel extends JPanel{
		//����������ı��򣬰�ť
		JTextField inputIp;
		JTextArea inputMsg;
		JButton btnSend;
		
		public MyPanel(){
			//����������ı��򣬰�ť
			inputIp = new JTextField();
			inputMsg = new JTextArea();
			btnSend = new JButton("����һ����Ϣ");
			//���ò��ַ�ʽ(����)
			setLayout(null);
			inputIp.setBounds(10, 10, 470, 30);//�����ı���ڷŵ�λ�����С
			this.add(inputIp);//���ı�����������
			
			inputMsg.setBounds(10, 50, 470, 240);//�����ı����λ�����С
			this.add(inputMsg);//���ı�����뵽�����
			
			btnSend.setBounds(350,310,130,35);//���ð�ť��λ�����С
			this.add(btnSend);//����ť���������
			
			setBackground(Color.DARK_GRAY);//�������ı�����ɫ
			//Ϊ��ť��ӵ���¼�
			btnSend.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// �����Ϣ�ķ���
					//��ȡ��Ϣ�����˵�ip��ַ
					String ip = inputIp.getText();
					//��ȡ��Ҫ���͵���Ϣ����
					String msg = inputMsg.getText();
					//������Ϣ���͹��߶���
					MyFeiQ f = new MyFeiQ();
					try {
						//������Ϣ
						f.sendMsg(ip, msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MyFrame();
	}

}
