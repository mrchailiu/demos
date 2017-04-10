package com.softeem.plane;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

//��Ϸ�����:���е���Ϸ���嶼�ڸĽ������
public class GamePanel extends JPanel implements MouseMotionListener{
	
	BufferedImage bg;
	Hero hero = new Hero();//����Ӣ�ۻ�
	Timer timer;//������ʱ��
	int bgY;//����������y��(�����޸�y��ֵ,ʵ�ֹ���Ч��)
	int speed = 10;//�����ĸı��ٶ�(ÿ�θı��������)
	//����һ�����ڴ洢�����ӵ��ļ���
	static List<Bullet> bullets = new ArrayList<Bullet>();
	//����һ�����ڴ洢���ел��ļ���
	static List<Enemy> planes = new ArrayList<Enemy>();
	SoundLoader sl;//������Ƶ���Ŷ���
	
	public GamePanel()
	{
		//���ز���ȡ����ͼƬ
		bg = ImageLoader.load("background.png");
		//��ʼ����ͼ��ʾ��λ��
		bgY = 700 - bg.getHeight();
		startGame();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//������Ϸ�ı���ͼƬ
		g.drawImage(bg, 0, bgY, bg.getWidth(), bg.getHeight(), null);
		//����Ӣ�ۻ�
		g.drawImage(hero.img, hero.x, hero.y, hero.width, hero.height, null);
		//�����ӵ�
		for(int i = 0;i<bullets.size();i++)
		{
			//ȡ��ÿһ���ӵ�
			Bullet b = bullets.get(i);
			g.drawImage(b.img, b.x, b.y, b.width, b.height, null);
		}
		//���Ƶл�
		for(int i = 0;i<planes.size();i++)
		{
			//��ȡÿһ�ܵл�
			Enemy e = planes.get(i);
			g.drawImage(e.img, e.x, e.y, e.width, e.height, null);
		}
	}
	
	//��ʼ��Ϸ
	public void startGame()
	{
		//������ʱ��
		timer = new Timer();
		//������ʱ����
		timer.schedule(new RefreshTask(),0,100);
		//���������л��Ķ�ʱ����
		timer.schedule(new EnemyTask(),0,500);
		//Ϊ����������¼�
		addMouseMotionListener(this);
		//���ű�������(���߳���ʵ��)
		new Thread(){
			public void run()
			{
				sl = new SoundLoader("game_music.wav");
				sl.loop();
			}
		}.start();
	}
	
	//����һ�������л�������
	class EnemyTask extends TimerTask{
		@Override
		public void run() {
			//����һ�ܵл�
			Enemy e = new Enemy();
			//���л����뼯��
			planes.add(e);
			//�����л��ķ����߳�
			e.start();
		}
	}
	
	//����һ����ʱˢ�½��������
	class RefreshTask extends TimerTask{
		@Override
		public void run() {
			//�����޸�flagֵ
			if(hero.flag == 1){
				hero.flag = 2;
			}else{
				hero.flag = 1;
			}
			//����flagֵѡ��ʹ��ָ��ͼƬ��Ⱦ�ɻ�
			hero.img = ImageLoader.load("hero"+hero.flag+".png");
			//�޸ı���ͼ��y��λ��
			bgY += speed;
			if(bgY > 0){
				//������ͼƬ�Ѿ���ʾ�����ʱ����λ�û�ԭ����ײ�
				bgY = 700 - bg.getHeight();
			}
			//�ý����ػ�
			repaint();
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("��ק�ˣ�ɧ�꣬û���õ�!");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//��ȡĿǰ���ָ�����ڵ�����
		int x = e.getX();
		int y = e.getY();
		System.out.println("��ǰ����x="+x+",y="+y);
		hero.moveTo(x, y);
	}
	
}
