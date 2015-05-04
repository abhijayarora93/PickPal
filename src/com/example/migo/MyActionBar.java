package com.example.migo;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class MyActionBar extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_action_bar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflator = getMenuInflater(); 
		inflator.inflate(R.menu.my_action_bar, menu);
//		requestWindowFeature(Window.FEATURE_ACTION_BAR);
		setContentView(R.layout.activity_my_action_bar);
		setTitle("MIGO");
		//getActionBar().setIcon(R.drawable.ic_launcher);
//		getActionBar().setHomeButtonEnabled(true);
//		getActionBar().setDisplayHomeAsUpEnabled(true);
		return true;
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	    // action with ID action_refresh was selected
	    case R.id.action_refresh:
	      Toast.makeText(this, "Refresh selected", Toast.LENGTH_SHORT)
	          .show();
	      break;
	    // action with ID action_settings was selected
	    case R.id.action_settings:
	      Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
	          .show();
	      break;
	    default:
	      break;
	    }

	    return true;
	}
	
}