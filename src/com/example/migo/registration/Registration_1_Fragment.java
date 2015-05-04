package com.example.migo.registration;
import com.*;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.migo.MyBaseActivity;
import com.example.migo.R;

public class Registration_1_Fragment extends Fragment{
	
	EditText name;
	EditText email1;
	EditText mobnum;
	EditText email2;
	EditText password;
	Button loginButton;
	Button nextButton;
	


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
          Bundle savedInstanceState) {
	  
	  View rootView = inflater.inflate(R.layout.fragment_registration_1, container, false);
	  
	  name = (EditText)rootView.findViewById(R.id.registration_1_name);
	  email1 = (EditText)rootView.findViewById(R.id.registration_1_personal_mail);
	  mobnum = (EditText)rootView.findViewById(R.id.registration_1_mobile);
	  email2= (EditText)rootView.findViewById(R.id.registration_1_company_mail);
	  password= (EditText)rootView.findViewById(R.id.registration_1_password);
	  loginButton= (Button)rootView.findViewById(R.id.login);
	  nextButton= (Button)rootView.findViewById(R.id.next);
	  
	  final ArrayList<User> users = new ArrayList<User>();
	  
	  
	  nextButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			User u1 = new User(name.getText().toString(),password.getText().toString(),mobnum.getText().toString(),email1.getText().toString(),email2.getText().toString());
			users.add(u1);
			 System.out.println(u1.name);
			 
				
				
			Intent intent = new Intent(getActivity(), MyBaseActivity.class); 
            startActivity(intent);
			// TODO Auto-generated method stub
			
		}
	});
	  
	  
	  
	  
	  return rootView;
	  
      
  }
	
}
