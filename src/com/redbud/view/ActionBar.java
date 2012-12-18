package com.redbud.view;

import com.redbud.lanjingcontact.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ActionBar extends RelativeLayout {
	private ImageView ivAddPersion;
	private ImageView ivSearch;

	public ActionBar(Context context) {
		super(context);
	}

	public ActionBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		LayoutInflater.from(getContext()).inflate(R.layout.actionbar,this,true);
		
		ivAddPersion = (ImageView)findViewById(R.id.iv_addpersion);
		ivSearch = (ImageView)findViewById(R.id.iv_search);
	}
	
	public void setIVOnSearchListener(OnClickListener listener){
		ivSearch.setOnClickListener(listener);
	}
	
	public void setIVOnAddPersionListener(OnClickListener listener){
		ivAddPersion.setOnClickListener(listener);
	}
}
