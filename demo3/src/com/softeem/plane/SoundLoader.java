package com.softeem.plane;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class SoundLoader {

	AudioClip clip;
	
	public SoundLoader(String name)
	{
		//����ָ����Ƶ�ļ�ΪURL����
		URL url = this.getClass().getResource("/musics/"+name);
		//����url��ַΪһ������������
		clip = Applet.newAudioClip(url);
	}
	//����
	public void start(){
		clip.play();
	}
	//ѭ��
	public void loop()
	{
		clip.loop();
	}
	//ֹͣ����
	public void stop(){
		clip.stop();
	}
}
