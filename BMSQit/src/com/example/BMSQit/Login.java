package com.example.BMSQit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.example.BMSQit.R;
import com.example.BMSQit.LandingPage;
import com.example.BMSQit.Login;
import com.example.BMSQit.Signup;

import android.app.*;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;


public class Login extends Activity{
	
	Button login_btn,signup;
	EditText user,passwd;
	TextView tv;
	URL url;
	String res;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#263238")));
		bar.setTitle("Login");
		
		setContentView(R.layout.login);
		
		signup = (Button) findViewById(R.id.btnSignup);
		login_btn = (Button) findViewById(R.id.btnLogin);
		user = (EditText) findViewById(R.id.username);
		passwd = (EditText) findViewById(R.id.pwd);
		tv = (TextView) findViewById(R.id.tv);
		
		login_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String username = user.getText().toString();
				final String password = passwd.getText().toString();
				
				Thread t = new Thread(){
					public void run(){
						try{
							
							url = new URL("https://bms-qit.herokuapp.com/login/"+username+"/"+password);

							try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
							    for (String line; (line = reader.readLine()) != null;) {
							        //System.out.println(line);
							        res += line;
							    }
							    //System.out.println("Status : "+res);
							    if(res.equals("null1")){
							    	Intent i = new Intent(Login.this,LandingPage.class);
							    	startActivity(i);
							    }else{
							    	runOnUiThread(new Runnable() {
							    	    public void run() {
							    	        tv.setText("Invalid Credentials!!");
							    	    }
							    	});
							    }
							    
							}
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				};
				
				t.start();
				
				
			}
		});
		
		signup.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
					Intent i = new Intent(Login.this,Signup.class);
					startActivity(i);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}

	
	
}


/*public class Login extends Activity{
	
	Button login_btn,signup;
	EditText user,passwd;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#076727")));
		bar.setTitle("Login");
		
		setContentView(R.layout.login);
		init();
		
	
		
		
				
				login_btn.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if(user.getText().toString().equalsIgnoreCase("stuname")){
							Intent i = new Intent(getBaseContext(),LandingPage.class);
							startActivity(i);
							finish();
						}else{
							Toast.makeText(getApplicationContext(), "Invalid creds!!", Toast.LENGTH_LONG).show();
						}
					
					}
					
				});

	signup.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try{
				Intent i = new Intent(getBaseContext(),Signup.class);
				startActivity(i);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	});
	}
	
			
	             private void init()
				{
					signup = (Button) findViewById(R.id.btnSignup);
					login_btn = (Button) findViewById(R.id.btnLogin);
					user = (EditText) findViewById(R.id.username);
					passwd = (EditText) findViewById(R.id.pwd);
					tv = (TextView) findViewById(R.id.tv);
				}
			
		
}*/
	
	
