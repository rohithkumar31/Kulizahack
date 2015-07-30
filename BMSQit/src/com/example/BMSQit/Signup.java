package com.example.BMSQit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.example.BMSQit.LandingPage;
import com.example.BMSQit.R;
import com.example.BMSQit.Signup;

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
	URL url;
	String res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#263238")));
		bar.setTitle("Signup");
		
		setContentView(R.layout.signup);
		
		init();
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				final String username = et1.getText().toString();
				final String usn = et2.getText().toString();
				final String email = et3.getText().toString();
				final String passwd = et4.getText().toString();
				
				Thread t = new Thread(){
					public void run(){
						try{
							url = new URL("https://bms-qit.herokuapp.com/signup/"+username+"/"+usn+"/"+email+"/"+passwd);

							try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
							    for (String line; (line = reader.readLine()) != null;) {
							        //System.out.println(line);
							        res += line;
							    }
							    //System.out.println("Status : "+res);
							    if(res.equals("null1")){
							    	System.out.println("Status : "+res);
							    	Intent i = new Intent(Signup.this,LandingPage.class);
							    	startActivity(i);
							    }else{
							    	System.out.println("Status : "+res);
							    	runOnUiThread(new Runnable() {
							    	    public void run() {
							    	    	Toast.makeText(getApplicationContext(), "Error Signing Up!! :-(", Toast.LENGTH_LONG).show();
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

/*public class Signup extends Activity{
	
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
	
	

}*/