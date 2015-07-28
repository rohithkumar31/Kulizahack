package com.example.BMSQit;

import com.example.BMSQit.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.Window;
import android.widget.TextView;


public class LandingPage extends Activity{
	
	Button pb,mb,pb1,mb1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#263238")));
		bar.setTitle("Trending Questions");
		
		setContentView(R.layout.landing_page);
		

       init();
		
		pb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(LandingPage.this, PostQuestion.class);
				startActivity(i);
				finish();
			}
		});
		
		mb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(LandingPage.this, Cse_Branch.class);
				startActivity(i);
				finish();
			}
		});
pb1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(LandingPage.this, PostQuestion.class);
				startActivity(i);
				finish();
			}
		});
		
		mb1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(LandingPage.this, Cse_Branch.class);
				startActivity(i);
				finish();
			}
		});
		
	}

	private void init() {
		// TODO Auto-generated method stub
		pb = (Button)findViewById(R.id.post_doubt_btn);
		mb = (Button)findViewById(R.id.more_btn);
		pb1 = (Button)findViewById(R.id.post_doubt_btn1);
		mb1 = (Button)findViewById(R.id.more_btn1);
	}	
		
	
	}

	
	

