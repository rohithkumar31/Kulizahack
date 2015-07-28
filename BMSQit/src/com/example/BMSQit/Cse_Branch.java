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

public class Cse_Branch extends Activity{

	Button ansbtn,chkansbtn,ansbtn1,chkansbtn1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#263238")));
		bar.setTitle("CSE");
		
		setContentView(R.layout.cse_branch);
		 init();
			
			ansbtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent i = new Intent(Cse_Branch.this, Answer.class);
					startActivity(i);
					finish();
				}
			});
      chkansbtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent i = new Intent(Cse_Branch.this, AnswersList.class);
					startActivity(i);
					finish();
				}
			});
			
      ansbtn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Cse_Branch.this, Answer.class);
				startActivity(i);
				finish();
			}
		});
chkansbtn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Cse_Branch.this, AnswersList.class);
				startActivity(i);
				finish();
			}
		});
		

}
 protected void init() {
	 ansbtn = (Button)findViewById(R.id.answer_btn);
	 chkansbtn = (Button)findViewById(R.id.check_answer_btn);
	 ansbtn1 = (Button)findViewById(R.id.answer_btn1);
	 chkansbtn1 = (Button)findViewById(R.id.check_answer_btn1);
	 
 }
}