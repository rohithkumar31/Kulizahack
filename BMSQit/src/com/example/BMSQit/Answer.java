package com.example.BMSQit;

import com.example.BMSQit.R;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;

public class Answer extends Activity{
	
	Button b;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#263238")));
		bar.setTitle("Answer");
		
		setContentView(R.layout.cse_branch);
}
}
