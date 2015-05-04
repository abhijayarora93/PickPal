package com.example.migo;


import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.provider.CalendarContract.Colors;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HomePreferencesFragment extends ListFragment {
	String[] mymonth = {"Favourites","Women Only", "All Cars"};
	int[] unclickImages = {R.drawable.fav_unpressed, R.drawable.women_only_unpressed, R.drawable.all_unpressed};
	int[] clickImages = {R.drawable.fav_pressed,R.drawable.women_only_pressed, R.drawable.all_pressed};
	
	
 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  
  /*
  HomePreferencesListAdapter myListAdapter = new ArrayAdapter<String>(
    getActivity(),
    android.R.layout.simple_list_item_1,
    month);
  setListAdapter(myListAdapter);
  */
  
  HomePreferencesListAdapter myListAdapter = 
    new HomePreferencesListAdapter(getActivity(), R.layout.row, mymonth, unclickImages);
  setListAdapter(myListAdapter);
 }

 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
   Bundle savedInstanceState) {
  return inflater.inflate(R.layout.listfragment1, container, false);
 }

 @Override
 public void onListItemClick(ListView l, View v, int position, long id) {
//  Toast.makeText(
//    getActivity(), 
//    getListView().getItemAtPosition(position).toString(), 
//    Toast.LENGTH_LONG).show();
//  ImageView n = (ImageView)getActivity().findViewById(R.id.icon);
	 
	 ImageView n = (ImageView)v.findViewById(R.id.icon);
	 TextView t = (TextView)v.findViewById(R.id.month);
	 t.setTextColor(getResources().getColor(R.color.yellow));
	 n.setImageResource(clickImages[position]);
	 for (int i = 0; i < l.getChildCount(); i++) {
		 if(i != position)
		 {
			View x =  (View)l.getChildAt(i);
			
			ImageView m = (ImageView)x.findViewById(R.id.icon);
			m.setImageResource(unclickImages[i]);
			TextView t1 = (TextView)x.findViewById(R.id.month);
			 t1.setTextColor(getResources().getColor(R.color.transparent_white));
		 }
			 
		
		}
	

 }

}