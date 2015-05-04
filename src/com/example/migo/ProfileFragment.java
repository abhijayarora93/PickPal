package com.example.migo;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;



public class ProfileFragment extends Fragment {
	public static Fragment newInstance(Context context) {
    	LeftFragment f = new LeftFragment();
 
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

}
