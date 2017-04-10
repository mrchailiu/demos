package com.softeem.demo;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/*
 	�����
 */
public class MyPanel extends JPanel{

	BufferedImage bg;//���ı���ͼƬ
	YearIcon icon = new YearIcon();//�������ͼ�����
	String tips = "�س���ʼ";
	boolean flag;//��־λ����ʶ�Ƿ�ʼ��ȡ
	FileUtils utils;
	Timer timer;//������ʱ��
	KeyLis kl;
	AudioClip clip;
	
	//������(���췽�������캯��)
	public MyPanel()
	{
		utils = new FileUtils();
		//�����쳣
		try {
			clip = Applet.newAudioClip(this.getClass().getResource("/resource/bgmusic.wav"));
			//����ͼƬ��ԴΪURL����
			URL url = this.getClass().getResource("/resource/08.jpg");
			//����url��Դ��Ϊһ��Image����
			bg = ImageIO.read(url);
			//�������ֲ����߳�
			new MusicThread().start();
			//Ϊ������ð����¼�������
			kl = new KeyLis();
			addKeyListener(kl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//���ڲ��ű������ֵ��߳�
	class MusicThread extends Thread{
		public void run(){
			//���ر������ֲ�����
			clip.loop();//ѭ������
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//���Ʊ���ͼƬ
		g.drawImage(bg, 0, 0, Settings.WIDTH, Settings.HEIGHT, null);
		//�������������ͼƬ
		g.drawImage(icon.img, icon.x, icon.y, icon.width, icon.height, null);
		//���������С
		g.setFont(new Font("΢���ź�", Font.BOLD, 40));
		//���û��ʵ���ɫ
		g.setColor(Color.WHITE);
		g.drawString(tips, Settings.WIDTH/2-80, Settings.HEIGHT/2);
	}
	
	//���������¼�������
	class KeyLis extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			//��ȡ�����İ�����
			int code = e.getKeyCode();
			//�ж��Ƿ��»س���
			if(code == 10){
				if(flag){
					//ֹͣ
					stop();
					flag = false;
				}else{
					//��ʼ
					begin();
					flag = true;
				}
			}
		}
	}
	//��ʼ��ȡ
	public void begin(){
		//������ʱ��
		timer = new Timer();
		//������ʱ����
		timer.schedule(new RefreshTask(),0,50);
	}
	
	//��������ˢ�³齱������
	class RefreshTask extends TimerTask{
		@Override
		public void run() {
			//�����������
			Random r = new Random();
			//�������
			int i = r.nextInt(utils.names.size());//0~(length-1)
			//����������ɵ�������ȡ����
			tips = utils.names.get(i);
			//�����ػ�
			repaint();
		}
	}
	
	//ֹͣ��ȡ
	public void stop(){
		//ȡ����ʱ����
		timer.cancel();
		//�Ӽ������Ƴ����н������˶�
		utils.names.remove(tips);
		//�Ƿ�û�пɳ齱�Ĳ�����
		if(utils.names.size()<=0){
			tips = "�齱����";
			//�Ƴ��¼�������
			removeKeyListener(kl);
		}
		repaint();//�ػ����
	}
}
