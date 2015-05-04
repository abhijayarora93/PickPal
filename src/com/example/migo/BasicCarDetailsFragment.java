package com.example.migo;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;

public class BasicCarDetailsFragment extends Fragment implements OnClickListener{
	 
	ScrollView sv;
	 View divider ;
	
	public static Fragment newInstance(Context context) {
    	BasicCarDetailsFragment f = new BasicCarDetailsFragment();
 
        return f;
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.basic_car_details_fragment, null);
        Button seat_1 = (Button)root.findViewById(R.id.seat_1);
        seat_1.setOnClickListener(this);
        return root;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        Button seat_1 = (Button)getActivity().findViewById(R.id.seat_1);
        seat_1.setOnClickListener(this);
        Button seat_2 = (Button)getActivity().findViewById(R.id.seat_2);
        seat_2.setOnClickListener(this);
        Button seat_3 = (Button)getActivity().findViewById(R.id.seat_3);
        seat_3.setOnClickListener(this);
        Button seat_4 = (Button)getActivity().findViewById(R.id.seat_4);
        seat_4.setOnClickListener(this);
        Button seat_5 = (Button)getActivity().findViewById(R.id.seat_5);
        seat_5.setOnClickListener(this);
        sv = (ScrollView) getActivity().findViewById(R.id.home_scrollview);
        divider = getActivity().findViewById(R.id.dummy_view);
        
        
    }
    
    
    
    public void displayBasicRideDetailsFragment(){
    	System.out.println("inside basic ride details frag");
    	getFragmentManager().beginTransaction().add(R.id.frag_frame, new BasicCarDetailsFragment()).commit();
        getFragmentManager().executePendingTransactions();
        
        
        
    }
    
    public void displayRideDetailsFragment(){
    	System.out.println("inside ride details frag");
    	getFragmentManager().beginTransaction().replace(R.id.frag_frame, new RideDetailsFragment()).commit();
        getFragmentManager().executePendingTransactions();
        
       
       

       
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		System.out.println("inside car click");

		if(v.getId()==R.id.seat_1||v.getId()==R.id.seat_2||v.getId()==R.id.seat_3||v.getId()==R.id.seat_4||v.getId()==R.id.seat_5){
			System.out.println("car view clicked");
			displayRideDetailsFragment();
			
				sv.post(new Runnable()
				{
				@Override
				  public void run()
				  {
				
				   sv.smoothScrollTo((int)divider.getX(), (int)divider.getY());
				  
				  }
				});
			
		}
		
	}
    

}
