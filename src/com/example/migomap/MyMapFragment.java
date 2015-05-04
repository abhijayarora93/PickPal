package com.example.migomap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;

import android.content.Context;
import android.graphics.Color;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.view.View.OnClickListener;

import com.example.migo.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.maps.GeoPoint;
//import com.example.migomap.MainActivity.ReadTask;
//import com.example.migomap.MainActivity.ParserTask;



public class MyMapFragment extends Fragment{
	GoogleMap map;
	//Button pooler;
	Button rider;
	
	private final LatLng LOCATION_PLACE1 = new LatLng(49.27645, -122.917587);
	private final LatLng LOCATION_PLACE2 = new LatLng(49.187, -121.917587);
	private static final LatLng LOWER_MANHATTAN = new LatLng(12.929850, 77.634431);
	private static final LatLng BROOKLYN_BRIDGE = new LatLng(12.959266, 77.698237);
	private static final LatLng WALL_STREET = new LatLng(40.7064, -74.0094);
	final String TAG = "PathGoogleMapActivity";
	
	public MyMapFragment(){
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       //ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_map, null);
        RelativeLayout ll = (RelativeLayout)inflater.inflate(R.layout.fragment_map, container, false);
        
        map = ((MapFragment) this.getActivity().getFragmentManager().findFragmentById(
                R.id.map)).getMap();
        //map.addMarker(new MarkerOptions().position(LOCATION_PLACE1).title("THIS IS PLACE 1!"));
		map.setMyLocationEnabled(true);
		//map.setTrafficEnabled(true);
		//super.onCreate(savedInstanceState);
			
		
		
	
		
		
		GeoPoint p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11;
		p1 = getLocationFromAddress("IIIT Bangalore, Bangalore");
		p2 = getLocationFromAddress("Forum Mall, Koramangla");
		p3 = getLocationFromAddress("Hongasandra");
		p4 = getLocationFromAddress("BTM Layout");
		p5 = getLocationFromAddress("Neelasandra");
		p6 = getLocationFromAddress("Armane Nagar");
		p7 = getLocationFromAddress("Jakkuru");
		p8 = getLocationFromAddress("HMT Estate");
		p9 = getLocationFromAddress("BSF Campus, Bangalore");
		p10 = getLocationFromAddress("Bileshivale");
		p11 = getLocationFromAddress("Sarkapalli");
		
//		System.out.println("Lat Obtained are.." + p1.getLatitudeE6()*1.0/1000000);
//		System.out.println("Long Obtained are.." + p1.getLongitudeE6()*1.0/1000000);
//		System.out.println("Lat Obtained are.." + p2.getLatitudeE6()*1.0/1000000);
//		System.out.println("Long Obtained are.." + p2.getLongitudeE6()*1.0/1000000);
		
		final LatLng MY_PLACE1 = new LatLng(p1.getLatitudeE6()*1.0/1000000, p1.getLongitudeE6()*1.0/1000000);
		final LatLng MY_PLACE2 = new LatLng(p2.getLatitudeE6()*1.0/1000000, p2.getLongitudeE6()*1.0/1000000);
		final LatLng MY_PLACE3 = new LatLng(p3.getLatitudeE6()*1.0/1000000, p3.getLongitudeE6()*1.0/1000000);
		final LatLng MY_PLACE4 = new LatLng(p4.getLatitudeE6()*1.0/1000000, p4.getLongitudeE6()*1.0/1000000);
		final LatLng MY_PLACE5 = new LatLng(p5.getLatitudeE6()*1.0/1000000, p5.getLongitudeE6()*1.0/1000000);
		final LatLng MY_PLACE6 = new LatLng(p6.getLatitudeE6()*1.0/1000000, p6.getLongitudeE6()*1.0/1000000);
		final LatLng MY_PLACE7 = new LatLng(p7.getLatitudeE6()*1.0/1000000, p7.getLongitudeE6()*1.0/1000000);
		final LatLng MY_PLACE8 = new LatLng(p8.getLatitudeE6()*1.0/1000000, p8.getLongitudeE6()*1.0/1000000);
		final LatLng MY_PLACE9 = new LatLng(p9.getLatitudeE6()*1.0/1000000, p9.getLongitudeE6()*1.0/1000000);
		final LatLng MY_PLACE10 = new LatLng(p10.getLatitudeE6()*1.0/1000000, p10.getLongitudeE6()*1.0/1000000);
		final LatLng MY_PLACE11 = new LatLng(p11.getLatitudeE6()*1.0/1000000, p11.getLongitudeE6()*1.0/1000000);
		
//		final LatLng MY_PLACE1 = new LatLng(49.27645, -122.917587);
//		final LatLng MY_PLACE2 = new LatLng(49.187, -121.917587);
				
			
				Button b1 = (Button) ll.findViewById(R.id.find_car_pooler);

				//Button b1 = (Button)this.getActivity().findViewById(R.id.find_car_pooler);
				b1.setOnClickListener(new OnClickListener(){
			
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						map.addMarker(new MarkerOptions().position(MY_PLACE8).title("Sourab: 8097234020").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
						
						map.addMarker(new MarkerOptions().position(MY_PLACE7).title("Shashank: 90898032087").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
						map.addMarker(new MarkerOptions().position(MY_PLACE6).title("Vikram: 98890348093").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
						map.addMarker(new MarkerOptions().position(MY_PLACE5).title("Anubhav: 9902873918").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
						map.addMarker(new MarkerOptions().position(MY_PLACE4).title("Akshay: 9591279206").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
					
							Button b1 = (Button)v;
							b1.setTextColor(Color.YELLOW);
					}
					
				});
				Button b2 = (Button) ll.findViewById(R.id.find_car_owner);

				//Button b1 = (Button)this.getActivity().findViewById(R.id.find_car_pooler);
				b2.setOnClickListener(new OnClickListener(){
			
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
							
								map.addMarker(new MarkerOptions().position(MY_PLACE1).title("Nisha: 79834793287").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
								map.addMarker(new MarkerOptions().position(MY_PLACE2).title("Tisha: 8727094729").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
								map.addMarker(new MarkerOptions().position(MY_PLACE3).title("Vikas: 9892370208").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
								map.addMarker(new MarkerOptions().position(MY_PLACE11).title("Sharma: 8719738629").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
								map.addMarker(new MarkerOptions().position(MY_PLACE10).title("Karishma: 9897398270").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
								map.addMarker(new MarkerOptions().position(MY_PLACE9).title("Esha: 989029980").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
								
							Button b2 = (Button)v;
							b2.setTextColor(Color.YELLOW);
					}
					
				});

		
//		
		
		String url = makeURL(MY_PLACE1.latitude, MY_PLACE1.longitude, MY_PLACE2.latitude, MY_PLACE2.longitude);
		ReadTask downloadTask = new ReadTask();
		downloadTask.execute(url);
		
	/////----------------------------------Zooming camera to position user-----------------

        LocationManager locationManager = (LocationManager) this.getActivity().getSystemService(Context.LOCATION_SERVICE);
                    Criteria criteria = new Criteria();

                    Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
                    if (location != null)
                    {
                        map.animateCamera(CameraUpdateFactory.newLatLngZoom(
                                new LatLng(location.getLatitude(), location.getLongitude()), 13));

                        CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(new LatLng(location.getLatitude(), location.getLongitude()))      // Sets the center of the map to location user
                        .zoom(12)                   // Sets the zoom
                        .bearing(80)                // Sets the orientation of the camera to east
                        .tilt(40)                   // Sets the tilt of the camera to 30 degrees
                        .build();                   // Creates a CameraPosition from the builder
                    map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                    }

/////----------------------------------Zooming camera to position user-----------------

        ArrayList<ArrayList<Integer>> markers = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>point1 = new ArrayList<Integer>();
        point1.add(p1.getLatitudeE6());
        point1.add(p1.getLongitudeE6());
        ArrayList<Integer>point2 = new ArrayList<Integer>();
        point2.add(p2.getLongitudeE6());
        point2.add(p2.getLongitudeE6());
        ArrayList<Integer>point3 = new ArrayList<Integer>();
        point3.add(p1.getLongitudeE6());
        point3.add(p1.getLongitudeE6());
        markers.add(point1);
        markers.add(point2);
        markers.add(point3);
        //addMarkersToMap(markers);
//        int[]a = {49, -122};
//        int[]b = {48, -121};
//        int[]c = {50, -121};
//        ArrayList<int[]> new_markers = new ArrayList<int[]>();
//        new_markers.add(a);
//        new_markers.add(b);
//        new_markers.add(c);
//        new_markers.add(p1.getLatitudeE6());
//        new_markers.add(p1.getLongitudeE6());
//        new_markers.add(p2.getLatitudeE6());
//        new_markers.add(p2.getLongitudeE6());
//        addMarkersToMap(new_markers);
        return ll;
    }
	
//	public void addMarkersToMap(ArrayList<int[]> latlng)
//	{
//		Integer latitude, longitude;
//		int i = 1;
//		 Iterator<int[]> it = latlng.iterator();
//
//		 for (int j = 0; j < latlng.size(); j++) { 
//			 
//			 	latitude = latlng.get(j)[0];
//		        longitude = latlng.get(j)[1];
//		            	i++;
//
//		            	map.addMarker(new MarkerOptions().position(new LatLng(latitude*1.0/1000000, longitude*1.0/1000000)).icon(BitmapDescriptorFactory.fromResource(R.drawable.car_map)));
//			 
//		         }
//		        		     }
//		
//		
//		
//	
//	
//	
//	public void addMarkers(ArrayList<Integer> latlng)
//	{
//		Integer latitude, longitude;
//		int i = 1;
//		 		        Iterator<Integer> itr = latlng.iterator();
//		        
//		        
//		        while(itr.hasNext())
//		            {
//		            	latitude = itr.next();
//		            	longitude = itr.next();
//		            	
//		            	map.addMarker(new MarkerOptions().position(new LatLng(latitude*1.0/1000000, longitude*1.0/1000000)).icon(BitmapDescriptorFactory.fromResource(R.drawable.car_map)));
//		            }
//		        i++;
//		    
//		
//		
//		
//	}
	public String makeURL (double sourcelat, double sourcelog, double destlat, double destlog ){
		System.out.print("Beginning Activity...\n");
        StringBuilder urlString = new StringBuilder();
        urlString.append("http://maps.googleapis.com/maps/api/directions/json");
        urlString.append("?origin=");// from
        urlString.append(Double.toString(sourcelat));
        urlString.append(",");
        urlString
                .append(Double.toString( sourcelog));
        urlString.append("&destination=");// to
        urlString
                .append(Double.toString( destlat));
        urlString.append(",");
        urlString.append(Double.toString( destlog));
        urlString.append("&sensor=false&mode=driving&alternatives=true");
        
        return urlString.toString();
 }
public GeoPoint getLocationFromAddress(String strAddress){
		
		Geocoder coder = new Geocoder(this.getActivity());
		List<Address> address;
		GeoPoint p1 = null;

		try {
		    address = coder.getFromLocationName(strAddress,5);
		    if (address == null) {
		        return null;
		    }
		    Address location = address.get(0);
		    location.getLatitude();
		    location.getLongitude();

		    p1 = new GeoPoint((int) (location.getLatitude() * 1E6),
		                      (int) (location.getLongitude() * 1E6));

		    System.out.println("Coordinates Obtained are.." + p1);
		    //LatLng LOCATION_PLACE3 = new LatLng(49.187, -121.917587);
		    
		    
		}catch(Exception ee)
        {

        }
		return p1;
    }

private class ReadTask extends AsyncTask<String, Void, String> {
	@Override
	protected String doInBackground(String... url) {
		String data = "";
		try {
			HttpConnection http = new HttpConnection();
			data = http.readUrl(url[0]);
		} catch (Exception e) {
			Log.d("Background Task", e.toString());
		}
		return data;
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		new ParserTask().execute(result);
	}
}

private class ParserTask extends
		AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

	@Override
	protected List<List<HashMap<String, String>>> doInBackground(
			String... jsonData) {

		JSONObject jObject;
		List<List<HashMap<String, String>>> routes = null;

		try {
			jObject = new JSONObject(jsonData[0]);
			PathJSONParser parser = new PathJSONParser();
			routes = parser.parse(jObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return routes;
	}

	@Override
	protected void onPostExecute(List<List<HashMap<String, String>>> routes) {
		ArrayList<LatLng> points = null;
		PolylineOptions polyLineOptions = null;

		// traversing through routes
		System.out.println("ALL FINE TILL HEREEE!");
		System.out.println("size of routes is "+ routes.size());
		for (int i = 0; i < routes.size(); i++) {
			points = new ArrayList<LatLng>();
			polyLineOptions = new PolylineOptions();
			List<HashMap<String, String>> path = routes.get(i);

			for (int j = 0; j < path.size(); j++) {
				HashMap<String, String> point = path.get(j);

				double lat = Double.parseDouble(point.get("lat"));
				double lng = Double.parseDouble(point.get("lng"));
				LatLng position = new LatLng(lat, lng);

				points.add(position);
			}

			polyLineOptions.addAll(points);
			polyLineOptions.width(8);
			polyLineOptions.color(Color.rgb(11,123,250));
			map.addPolyline(polyLineOptions);
		}

		
	}
}
//public void onClick_Book(View v){
//	
//	Button b = (Button)this.getActivity().findViewById(R.id.book_button);
//	b.setTextColor(Color.WHITE);
//	
//      
//}





}

