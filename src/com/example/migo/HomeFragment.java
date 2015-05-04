package com.example.migo;


import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;



public class HomeFragment extends Fragment {
	public static Fragment newInstance(Context context) {
    	HomeFragment f = new HomeFragment();
 
        return f;
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_home, null);
        
         
        
       return root;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        
        this.displayBasicRideDetailsFragment();
        

        

        Button displayPreferencesButton = (Button)getActivity().findViewById(R.id.displaybutton);
        displayPreferencesButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.setVisibility(View.INVISIBLE);
//				View preferencesFragment = getActivity().findViewById(R.id.custom_listview);
//				//View preferencesList = preferencesFragment.findViewById(R.id.custom_listview);
//				preferencesFragment.setVisibility(View.VISIBLE);
					 android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
					 FragmentTransaction transaction = fragmentManager.beginTransaction();
					 transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
					 //Fragment nf = getActivity().getSupportFragmentManager().findFragmentById(R.id.preferences_fragment);
					// Fragment nf = getActivity().getSupportFragmentManager().findFragmentById(R.id.);
						
			      //fragmentManager.beginTransaction().replace(R.id.preferences_fragment, new HomePreferencesFragment()).commit();
					 transaction.replace(R.id.preferences_fragment, new HomePreferencesFragment()).commit();
					 
					
			     // fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).show(new HomePreferencesFragment()).commit();
			}
		});

    }
    
    public void displayBasicRideDetailsFragment(){
    	System.out.println("inside basic ride details frag");
    	getChildFragmentManager().beginTransaction().add(R.id.frag_frame, new BasicCarDetailsFragment()).commit();
        getChildFragmentManager().executePendingTransactions();
        
       
        
        
       // Button seat = (Button)getView().findViewById(R.id.seat_1);
        
        
    }
    
    public void displayRideDetailsFragment(){
    	System.out.println("inside ride details frag");
    	getChildFragmentManager().beginTransaction().replace(R.id.frag_frame, new RideDetailsFragment()).commit();
        getChildFragmentManager().executePendingTransactions();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
