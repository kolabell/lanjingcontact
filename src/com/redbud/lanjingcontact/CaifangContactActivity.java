package com.redbud.lanjingcontact;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CaifangContactActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.caifangcontact);
		
		findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TextView tv = (TextView)findViewById(R.id.tv_text);
				tv.setText("some text");
			}
		});
	}

}
