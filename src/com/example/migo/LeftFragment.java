package com.example.migo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LeftFragment extends Fragment {
	public static Fragment newInstance(Context context) {
    	LeftFragment f = new LeftFragment();
 
        return f;
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_main, null);
        
        return root;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //savedInstanceState.putString("userid", "username");

        

        ContactRelativeView contact_relative_layout = (ContactRelativeView)getActivity().findViewById(R.id.contact_relative_view);
        contact_relative_layout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				ContactRelativeView cv = (ContactRelativeView)v;
				
//				if(cv.getClicked().equals("false"))
//					cv.setClicked("true");
//				else cv.setClicked("false");
				
				
				
//				ContactRelativeView cv = (ContactRelativeView) getActivity().findViewById(R.id.contact_relative_view);
//				cv.setClicked("true");
				
//				 android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//				
//			      fragmentManager.beginTransaction().replace(R.id.content_frame, Fragment.instantiate(getActivity(), "com.example.migo.ProfileFragment")).addToBackStack("profile back stack").commit();
//

				
					 
					

			}
		});

    }
		

}
