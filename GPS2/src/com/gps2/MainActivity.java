package com.gps2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity implements LocationListener {

	private LocationManager locationManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*
		 * LocationManager locationManager = (LocationManager)
		 * getSystemService(Context.LOCATION_SERVICE);
		 * locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
		 * 0, 0, this);
		 * 
		 * Location location =
		 * locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		 * 
		 * TextView tekst = (TextView) this.findViewById(R.id.textView1);
		 * TextView szerokosc = (TextView) this.findViewById(R.id.szerokosc);
		 * TextView dlugosc = (TextView) this.findViewById(R.id.dlugosc);
		 * 
		 * tekst.setText(location.toString());
		 * szerokosc.setText("Szerokosc: "+String
		 * .valueOf(location.getLatitude()));
		 * dlugosc.setText("Dlugosc: "+String.valueOf(location.getLongitude()));
		 */
	
		/*	LocationListener mlocListener = new MyLocationListener();
			locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
			//i tak to nie dzia³a.
*/
	}

	protected void onResume() {

		super.onResume();
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		if (!locationManager
				.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER)) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("GPS nie jest w³¹czony")
					.setMessage("Czy chcesz przejœæ do ustawieñ GPS?")
					.setCancelable(true)
					.setPositiveButton("Tak",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int id) {
									// TODO Auto-generated method stub
									startActivity(new Intent(
											Settings.ACTION_SECURITY_SETTINGS));
								}
							})
					.setNegativeButton("Nie",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int id) {
									// TODO Auto-generated method stub
									dialog.cancel();
									finish();
								}
							});

			AlertDialog alert = builder.create();
			alert.show();

		}

		else {

			 getSystemService(Context.LOCATION_SERVICE);
			
			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);		
	    		
			//Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

			TextView tekst = (TextView) this.findViewById(R.id.textView1);
			TextView szerokosc = (TextView) this.findViewById(R.id.szerokosc);
			TextView dlugosc = (TextView) this.findViewById(R.id.dlugosc);
			
			szerokosc.setText("");
			dlugosc.setText("");
			
			tekst.setText("Czekaj, pobieranie danych GPS...");
			
			Location location=null;
			
			while(location==null){
				
				locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);			    		
				location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			}
			
			
			if (location != null) {
	
				tekst.setText(location.toString());
				szerokosc.setText("Szerokosc: "
						+ String.valueOf(location.getLatitude()));
				dlugosc.setText("Dlugosc: "
						+ String.valueOf(location.getLongitude()));

			} 
			else {	
				//ci¹gle to wyœwietla, choæby nie wiem co
				tekst.setText("Twój GPS jest do kitu, wyrzuæ go.");		
				szerokosc.setText("(location==null)");
				
			}
		}

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

		Log.i("Geo_Location", "Latitude: " + latitude + ", Longitude: "
				+ longitude);

	}

	@Override
	public void onProviderDisabled(String provider)
    {
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
