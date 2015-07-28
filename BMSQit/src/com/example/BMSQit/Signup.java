package com.example.BMSQit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends Activity{
	
	EditText et1,et2,et3,et4;
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#076727")));
		bar.setTitle("Signup");
		
		setContentView(R.layout.signup);
	}
				
	private void init() {
		// TODO Auto-generated method stub
		et1 = (EditText) findViewById(R.id.name);
		et2 = (EditText) findViewById(R.id.usn);
		et3 = (EditText) findViewById(R.id.email);
		et4 = (EditText) findViewById(R.id.pwd);
		btn = (Button) findViewById(R.id.btnSign);
	}
	
	

}