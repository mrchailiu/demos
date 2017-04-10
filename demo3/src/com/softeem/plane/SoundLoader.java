package com.softeem.plane;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class SoundLoader {

	AudioClip clip;
	
	public SoundLoader(String name)
	{
		//加载指定音频文件为URL对象
		URL url = this.getClass().getResource("/musics/"+name);
		//加载url地址为一个剪辑器对象
		clip = Applet.newAudioClip(url);
	}
	//播放
	public void start(){
		clip.play();
	}
	//循环
	public void loop()
	{
		clip.loop();
	}
	//停止播放
	public void stop(){
		clip.stop();
	}
}
