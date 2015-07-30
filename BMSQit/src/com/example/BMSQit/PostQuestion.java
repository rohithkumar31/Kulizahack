package com.example.BMSQit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.example.BMSQit.R;
import com.example.BMSQit.LandingPage;
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

public class PostQuestion extends Activity {
	EditText qbranch,editText1;
	Button btnSubmit;
	URL url;
	String res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#263238")));
		bar.setTitle("Post A Question");
		
		setContentView(R.layout.post_question);
		
		
		qbranch = (EditText) findViewById(R.id.q_branch);
		editText1 = (EditText) findViewById(R.id.editText1);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		
		btnSubmit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String quesbranch = qbranch.getText().toString();
				final String question = editText1.getText().toString();
				
				Thread t = new Thread(){
					public void run(){
						try{
							url = new URL("https://bms-qit.herokuapp.com/post_ques/abc2/"+question+"/"+quesbranch);

							try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
							    for (String line; (line = reader.readLine()) != null;) {
							        //System.out.println(line);
							        res += line;
							    }
							    //System.out.println("Status : "+res);
							    if(res.equals("null1")){
							    	System.out.println("Status : "+res);
							    	runOnUiThread(new Runnable() {
							    	    public void run() {
							    	    	Toast.makeText(getApplicationContext(), "Question Added!! :-D", Toast.LENGTH_LONG).show();
							    	    	Intent i = new Intent(PostQuestion.this,LandingPage.class);
									    	startActivity(i);
							    	    }
							    	});
							    	
							    }else{
							    	System.out.println("Status : "+res);
							    	runOnUiThread(new Runnable() {
							    	    public void run() {
							    	    	Toast.makeText(getApplicationContext(), "Error Adding Question!! :-(", Toast.LENGTH_LONG).show();
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
}
