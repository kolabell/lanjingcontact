package com.redbud.lanjingcontact;

import java.util.ArrayList;
import java.util.List;

import com.redbud.adapter.ViewPagerAdatper;
import com.redbud.view.ActionBar;

import android.os.Bundle;
import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity 
								implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener{
	private ViewPager mPager;
	private List<View> listViews;
	private LocalActivityManager manager = null;
	private TabHost mTabHost;
	private final Context mContext = this;
	private ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		actionBar = (ActionBar)findViewById(R.id.actionbar);
		actionBar.setIVOnSearchListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				onSearchRequested();
				Toast.makeText(mContext, "ivsearch", Toast.LENGTH_LONG).show();
			}
		});
		
		manager = new LocalActivityManager(this, true);
		manager.dispatchCreate(savedInstanceState);
		
		mTabHost = (TabHost)findViewById(android.R.id.tabhost);
		mTabHost.setup(manager);
		
		setupTab();
		
		initViewPager();
	}
	
	private void setupTab(){
		Intent intent;
		String tag;
		View viewtab;
		
		intent = new Intent(this, CaifangContactActivity.class);
		tag = "采访通讯录";
		viewtab = createTabView(mContext, tag, false);
		mTabHost.addTab(mTabHost.newTabSpec(tag).setIndicator(viewtab).setContent(intent));
		
		intent = new Intent(this,BBSMemeberContactActivity.class);
		tag = "会员通讯录";
		viewtab = createTabView(mContext, tag, true);
		mTabHost.addTab(mTabHost.newTabSpec(tag).setIndicator(viewtab).setContent(intent));
		
		mTabHost.setCurrentTab(0);
		mTabHost.setOnTabChangedListener(this);
		
	}
	
	private static View createTabView(final Context context, final String text,final boolean isLastTab) {
		View view = LayoutInflater.from(context).inflate(R.layout.tabs_bg, null);
		TextView tv = (TextView) view.findViewById(R.id.tabsText);
		tv.setText(text);
		if(isLastTab){
			ImageView ivdivider = (ImageView) view.findViewById(R.id.iv_divider);
			ivdivider.setVisibility(View.GONE);
		}
		return view;
	}
	
	private void initViewPager(){
		mPager = (ViewPager) findViewById(R.id.viewpager);
		listViews = new ArrayList<View>();
		ViewPagerAdatper mpAdapter = new ViewPagerAdatper(listViews);
		Intent intent1 = new Intent(mContext,CaifangContactActivity.class);
		listViews.add(manager.startActivity("A", intent1).getDecorView());
		Intent intent2 = new Intent(mContext,BBSMemeberContactActivity.class);
		listViews.add(manager.startActivity("A", intent2).getDecorView());
		mPager.setAdapter(mpAdapter);
		mPager.setCurrentItem(0);
		mPager.setOnPageChangeListener(this);
	}
	
	

	@Override
	public boolean onSearchRequested() {
		Toast.makeText(mContext, "search", Toast.LENGTH_LONG).show();
		return super.onSearchRequested();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		mTabHost.setCurrentTab(arg0);
	}

	@Override
	public void onTabChanged(String arg0) {
		int pos = this.mTabHost.getCurrentTab();
		this.mPager.setCurrentItem(pos);
	}

}
