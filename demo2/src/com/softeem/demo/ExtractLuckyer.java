package com.softeem.demo;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class ExtractLuckyer extends JFrame{

	public ExtractLuckyer(){
	
		setSize(Settings.WIDTH,Settings.HEIGHT);	//���ô����С
		setTitle(Settings.TITLE);					//���ñ���
		setLocationRelativeTo(null);				//���ô���Ĭ�Ͼ���
		setResizable(false);						//��ֹ�ı䴰���С
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//�رմ����Զ��˳������
		final MyPanel panel = new MyPanel();
		add(panel);//�������봰��
		setVisible(true);							//��ʾ����
		//������ȡ����
		panel.requestFocus();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
				if(panel.clip != null){
					panel.clip.stop();
					System.exit(0);
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new ExtractLuckyer();
	}
}
