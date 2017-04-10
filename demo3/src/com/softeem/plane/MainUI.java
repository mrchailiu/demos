package com.softeem.plane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
//��Ϸ������
public class MainUI extends JFrame{
	//������Ϸ���
	GamePanel panel = new GamePanel();
	
	public MainUI()
	{
		setSize(430,700);
		setTitle("SOFTEEM��ɻ�(by MRChai)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//������ر�ʱ�Զ��ر������
		setResizable(false);	//�̶������С
		setLocationRelativeTo(null); //��������Ļ�о���
		add(panel); //�����嵽������
		setVisible(true);
		//Ϊ��������¼�
		addWindowListener(new WindowClose());
	}
	
	//�����¼�
	class WindowClose extends WindowAdapter{
		//�����屻�ر�ʱ��ֹͣ����
		@Override
		public void windowClosed(WindowEvent e) {
			super.windowClosed(e);
			panel.sl.stop();
		}
	}
	
	public static void main(String[] args) {
		new MainUI();
	}

}
