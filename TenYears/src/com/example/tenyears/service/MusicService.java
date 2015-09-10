package com.example.tenyears.service;

import com.example.tenyears.R;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {
	private MediaPlayer mediaPlayer = null;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		 
		if(intent.getStringExtra("musicName").endsWith("1"))
		{
		mediaPlayer = MediaPlayer.create(this, R.raw.xihuanni);
		}
		else if(intent.getStringExtra("musicName").endsWith("2"))
		{
			 
			mediaPlayer = MediaPlayer.create(this, R.raw.jintianniyaojiagewo); 
		}
		else if(intent.getStringExtra("musicName").endsWith("3"))
		{
			mediaPlayer = MediaPlayer.create(this, R.raw.nideai); 
		}
		else if(intent.getStringExtra("musicName").endsWith("4"))
		{
			mediaPlayer = MediaPlayer.create(this, R.raw.zuilangmangdeshi); 
		}
		
		mediaPlayer.setLooping(true);
		mediaPlayer.start();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mediaPlayer.stop();
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
