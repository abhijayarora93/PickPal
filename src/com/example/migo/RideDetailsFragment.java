package com.example.migo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class RideDetailsFragment extends Fragment implements OnClickListener {
	
	ContactRelativeView contact_relative_layout ;
	PickUpRelativeView pick_relative_layout;
	DropMeRelativeView drop_relative_layout;
	Button confirmRide;
	
	
	public static Fragment newInstance(Context context) {
    	RideDetailsFragment f = new RideDetailsFragment();
 
        return f;
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.ride_details_fragment, null);
        
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
        contact_relative_layout = (ContactRelativeView)getActivity().findViewById(R.id.contact_relative_view_ride);
        contact_relative_layout.setOnClickListener(this);
        pick_relative_layout = (PickUpRelativeView)getActivity().findViewById(R.id.pickup_relative_view_ride);
        pick_relative_layout.setOnClickListener(this);
        drop_relative_layout = (DropMeRelativeView)getActivity().findViewById(R.id.drop_relative_view_ride);
        drop_relative_layout.setOnClickListener(this);
        

        confirmRide = (Button)getActivity().findViewById(R.id.confirm_ride_button);
        confirmRide.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("HOLA RIDE YO!!! ");
				
				Intent intent = new Intent(getActivity(), PaymentActivity.class);
				startActivity(intent);
				
			}
		});

        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Segoe Print.ttf");
        TextView tv  = (TextView) getActivity().findViewById(R.id.informal_text_textview);
        tv.setTypeface(custom_font);
        
        
}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.contact_relative_view_ride :
			System.out.println("contact relative clicked ride"+contact_relative_layout.getClicked());
			contact_relative_layout.setClicked();
			break;
		case R.id.pickup_relative_view_ride :
			pick_relative_layout.setClicked();
			break;
		case R.id.drop_relative_view_ride : 
			drop_relative_layout.setClicked();
			break;
		}
		
			
	
		
	}
}
