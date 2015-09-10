package com.example.tenyears;
 
import java.util.ArrayList;
import java.util.List;

import com.example.tenyears.service.MusicService;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity {
	private ViewPager viewPager;
	private List<View> list = new ArrayList<View>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewPager = (ViewPager) findViewById(R.id.frame_main_viewpage);
		 
			View v = LayoutInflater.from(this).inflate(R.layout.firstpage, null);
			list.add(v);
		 v= LayoutInflater.from(this).inflate(R.layout.secondpage, null);
		 list.add(v);

		 v= LayoutInflater.from(this).inflate(R.layout.thirdpage, null);
		 list.add(v);

		 v= LayoutInflater.from(this).inflate(R.layout.fourthpage, null);
		 list.add(v);

		 v= LayoutInflater.from(this).inflate(R.layout.fifthpage, null);
		 list.add(v);

		 v= LayoutInflater.from(this).inflate(R.layout.sixthpage, null);
		 list.add(v);
		System.out.println(list.size());
		
		viewPager.setAdapter(new Adapter(this, list));
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				if (arg0==0)
				{
					Intent intent=new Intent(MainActivity.this,MusicService.class);
					stopService(intent); 
						intent.putExtra("musicName", "1");
						startService(intent);
						 
				}
				if(arg0==1)
				{
					
				}
				else if(arg0==2)
				{
					Intent intent=new Intent(MainActivity.this,MusicService.class);
					stopService(intent); 
					intent.putExtra("musicName", "2");
					startService(intent);
				} 
				else if(arg0==3)
				{
					Intent intent=new Intent(MainActivity.this,MusicService.class);
					stopService(intent); 
					intent.putExtra("musicName", "3");
					startService(intent);
				} 
				else if(arg0==5)
				{
					Intent intent=new Intent(MainActivity.this,MusicService.class);
					stopService(intent); 
					intent.putExtra("musicName", "4");
					startService(intent);
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	
	public class Adapter extends PagerAdapter{
		private List<View> list;
		
		public Adapter(Context context, List<View> list){
			this.list = list;
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			((ViewPager)container).removeView(list.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			if(position==0)
			{
				Intent intent=new Intent(MainActivity.this,MusicService.class);
				intent.putExtra("musicName", "1");
				startService(intent);
				
			}
			
			View v = list.get(position);
			((ViewPager)container).addView(v);
			return v;
		} 
		
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
	}

}
