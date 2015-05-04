package com.example.migo;

import java.util.ArrayList;
import com.*;

import com.example.migo.registration.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterationActivity extends Activity {

	EditText name;
	EditText email1;
	EditText mobnum;
	EditText email2;
	EditText password;
	Button loginButton;
	Button nextButton;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registeration);
		 name = (EditText)findViewById(R.id.registration_1_name);
		  email1 = (EditText)findViewById(R.id.registration_1_personal_mail);
		  mobnum = (EditText)findViewById(R.id.registration_1_mobile);
		  email2= (EditText)findViewById(R.id.registration_1_company_mail);
		  password= (EditText)findViewById(R.id.registration_1_password);
		  loginButton= (Button)findViewById(R.id.login);
		  nextButton= (Button)findViewById(R.id.next);
		  final String message =  new String();
		  
		  final ArrayList<User> users = new ArrayList<User>();
		  
		  
		  nextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("CHOOT");
				User u1 = new User(name.getText().toString(),password.getText().toString(),mobnum.getText().toString(),email1.getText().toString(),email2.getText().toString());
				users.add(u1);
				 
				 
					
					
				Intent intent = new Intent(getApplicationContext(), MyBaseActivity.class); 
				intent.putExtra("message", name.getText().toString());
				startActivity(intent);
	            
				// TODO Auto-generated method stub
				
			}
		});
		  

		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registeration, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
