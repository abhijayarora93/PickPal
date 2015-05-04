package com.example.migo;

import java.util.Locale;
import com.example.migo.registration.Registration_1_Fragment;
import com.example.migomap.*;



import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyBaseActivity extends ActionBarActivity {
	
	private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;

    private CharSequence drawerTitle;
    private CharSequence title;
    private String[] drawerListArray;
    
    @Override
    protected void onCreate(Bundle savedInstanceState){
    	super.onCreate(savedInstanceState);
    	this.setContentView(R.layout.activity_my_base);
    	Bundle bundle = getIntent().getExtras();
    	String message = bundle.getString("message");
    	TextView changeName = (TextView)findViewById(R.id.user_move_name);
    	changeName.setText(message);
    	
    	title = drawerTitle = this.getTitle();
    	drawerListArray = this.getResources().getStringArray(R.array.page_list_array);
    	drawerLayout = (DrawerLayout) this.findViewById(R.id.drawer_layout);
    	drawerList = (ListView) this.findViewById(R.id.left_drawer);
    	drawerList.setAdapter(new ArrayAdapter<String>(this,R.layout.drawer_list_item));
    	System.out.println(message);
    	
      // set a custom shadow that overlays the main content when the drawer opens
      //mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
      // set up the drawer's list view with items and click listener
      drawerList.setAdapter(new ArrayAdapter<String>(this,
              R.layout.drawer_list_item, drawerListArray));
      drawerList.setOnItemClickListener(new DrawerItemClickListener());
    	
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      getSupportActionBar().setHomeButtonEnabled(true);
      
      drawerToggle = new ActionBarDrawerToggle(
              this,                  /* host Activity */
              drawerLayout,         /* DrawerLayout object */
              R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
              R.string.drawer_open,  /* "open drawer" description for accessibility */
              R.string.drawer_close  /* "close drawer" description for accessibility */
              ) {
          public void onDrawerClosed(View view) {
              getSupportActionBar().setTitle(title);
              invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
          }

          public void onDrawerOpened(View drawerView) {
              getSupportActionBar().setTitle(drawerTitle);
              invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
          }
      };
      drawerLayout.setDrawerListener(drawerToggle);

      if (savedInstanceState == null) {
          //selectItem(0);
      }
      
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      
        this.setTitle("PickPal");
//        this.getSupportActionBar().setBackgroundDrawable(this.getResources().getDrawable(R.color.apptheme_color));
//        this.getSupportActionBar().set
//        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        this.getSupportActionBar().setCustomView(R.layout.actionbar);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_base, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
    	LinearLayout drawer_left  = (LinearLayout) this.findViewById(R.id.left_layout);
        boolean drawerOpen = drawerLayout.isDrawerOpen(drawer_left);
        menu.findItem(R.id.action_refresh).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         // The action bar home/up action should open or close the drawer.
         // ActionBarDrawerToggle will take care of this.
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
	    // action with ID action_refresh was selected
	    case R.id.action_refresh:
	      Toast.makeText(this, "Refresh selected", Toast.LENGTH_SHORT)
	          .show();
	      	return true;
	      
	    // action with ID action_settings was selected
	    case R.id.action_settings:
	      Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
	          .show();
	      		return true;
	      
	   

	    
	
        default:
            return super.onOptionsItemSelected(item);
        }
    }

    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            changeFragment(position);
        }
    }
    
    private void changeFragment(int position){
      
//      args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
//      fragment.setArguments(args);

    String[] fragmentName = {"com.example.migo.HomeFragment","com.example.migomap.MyMapFragment","com.example.migo.MainFragment","com.example.migo.LeftFragment","com.example.migo.LeftFragment"};
    
    	
      android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
      fragmentManager.beginTransaction().replace(R.id.content_frame, Fragment.instantiate(MyBaseActivity.this, fragmentName[position])).commit();

      // update selected item and title, then close the drawer
      drawerList.setItemChecked(position, true);
      setTitle("Registration");
      LinearLayout drawerLinearLayout = (LinearLayout)findViewById(R.id.left_layout);
      drawerLayout.closeDrawer(drawerLinearLayout);
    }

//    private void selectItem(int position) {
//        // update the main content by replacing fragments
//        Fragment fragment = new PlanetFragment();
//        Bundle args = new Bundle();
//        args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
//        fragment.setArguments(args);
//
//        FragmentManager fragmentManager = getFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
//
//        // update selected item and title, then close the drawer
//        mDrawerList.setItemChecked(position, true);
//        setTitle(mPlanetTitles[position]);
//        mDrawerLayout.closeDrawer(mDrawerList);
//    }

    @Override
    public void setTitle(CharSequence title) {
        title = title;
        getSupportActionBar().setTitle(title);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        drawerToggle.onConfigurationChanged(newConfig);
    }
    
    
//  public void onClick_Book(View v){
//	
//	Button b = (Button)v;
//
//	if(!b.isSelected()){
//		b.setSelected(true);
//		b.setTextColor(Color.WHITE);
//		b.setText("Booked");
//	
//	}else {
//		b.setSelected(false);
//		b.setTextColor(Color.BLACK);
//		b.setText("Book");
//	}
//	
//     
//}

  
  
	
	
	
}
