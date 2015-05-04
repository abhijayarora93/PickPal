package com.example.migo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePreferencesListAdapter extends ArrayAdapter<String> {
	  
	  Context myContext;
	  String[] month;
	  int[] images;

	  public HomePreferencesListAdapter(Context context, int textViewResourceId,
	    String[] objects, int[] imageids ) {
	   super(context, textViewResourceId, objects);
	   myContext = context;
	   month = objects;
	   images = imageids;
	   
	  }

	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	   //return super.getView(position, convertView, parent);
	   
	   LayoutInflater inflater = 
	     (LayoutInflater)myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	   View row=inflater.inflate(R.layout.row, parent, false);
	   TextView label=(TextView)row.findViewById(R.id.month);
	   label.setText(month[position]);
	   ImageView icon=(ImageView)row.findViewById(R.id.icon);
	   
	   //Customize your icon here
	   icon.setImageResource(images[position]);
	  
	   
	   return row;
	  }

	 }
