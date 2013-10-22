package com.gps2;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity implements LocationListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

	    Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
	    
	    TextView tekst = (TextView) this.findViewById(R.id.textView1);
	    TextView szerokosc = (TextView) this.findViewById(R.id.szerokosc);
	    TextView dlugosc = (TextView) this.findViewById(R.id.dlugosc);
	    
	    tekst.setText(location.toString());
	    szerokosc.setText("Szerokosc: "+String.valueOf(location.getLatitude()));
	    dlugosc.setText("Dlugosc: "+String.valueOf(location.getLongitude()));
	    
	    
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		double latitude = (double) (location.getLatitude());
	    double longitude = (double) (location.getLongitude());

	    Log.i("Geo_Location", "Latitude: " + latitude + ", Longitude: " + longitude);

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

}
