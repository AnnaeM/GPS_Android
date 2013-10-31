package com.gps2;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

public class MyLocationListener implements LocationListener
{

  public void onLocationChanged(Location loc)
  {
    loc.getLatitude();
    loc.getLongitude();

    String Text = "My current location is: " +
    "Latitud = " + loc.getLatitude() +
    "Longitud = " + loc.getLongitude();

    Toast.makeText( getApplicationContext(), Text, Toast.LENGTH_SHORT).show();
  }

  private Context getApplicationContext() {
	// TODO Auto-generated method stub
	return null;
}

public void onProviderDisabled(String provider)
  {
    Toast.makeText( getApplicationContext(), "Gps Disabled", Toast.LENGTH_SHORT ).show();
  }

  public void onProviderEnabled(String provider)
  {
    Toast.makeText( getApplicationContext(), "Gps Enabled", Toast.LENGTH_SHORT).show();
  }

  public void onStatusChanged(String provider, int status, Bundle extras)
  {

  }
}