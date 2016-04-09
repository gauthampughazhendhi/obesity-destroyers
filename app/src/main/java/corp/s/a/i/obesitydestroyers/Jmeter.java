package corp.s.a.i.obesitydestroyers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
//import com.google.android.gms.location.FusedLocationProviderApi;


/***********  Create class and implements with LocationListener **************/
public class Jmeter extends Activity implements LocationListener {

    private LocationManager locationManager;
    SharedPreferences sp;
    
    TextView t,dc,cb,cbc;
    Double lat=0.0,lon=0.0,lon1=0.0,lat1=0.0,l=0.0,w,c=0.0;
    int f=0, gps = 1 ,c1 = 0;
    Button b;
    String g,k;
    public static String file="shareddata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //fun();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.jmeter);
        t=(TextView)findViewById(R.id.tvdist);
        b=(Button)findViewById(R.id.button4);
        dc=(TextView)findViewById(R.id.tvdc);
        cb=(TextView)findViewById(R.id.tvcb);
        cbc=(TextView)findViewById(R.id.tv3);
        sp =getSharedPreferences("shareddata", 0);
        String n= sp.getString("weight", "80");
        w=Double.valueOf(n);
        w=w*2.2046;

       final int a= sp.getInt("jm", 0);
        final int b1= sp.getInt("jm1", 1);



        //dc.setText(String.valueOf(a));






        /********** get Gps location service LocationManager object ***********/
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        t.setVisibility(View.INVISIBLE);
        dc.setVisibility(View.INVISIBLE);
        cb.setVisibility(View.INVISIBLE);
        cbc.setVisibility(View.INVISIBLE);
 f=0;

   //              CAL METHOD requestLocationUpdates

        // Parameters :
        //   First(provider)    :  the name of the provider with which to register
        //   Second(minTime)    :  the minimum time interval for notifications,
        //                         in milliseconds. This field is only used as a hint
        //                         to conserve power, and actual time between location
        //                         updates may be greater or lesser than this value.
        //   Third(minDistance) :  the minimum distance interval for notifications, in meters
        //   Fourth(listener)   :  a {#link LocationListener} whose onLocationChanged(Location)
        //                         method will be called for each location update


        locationManager.removeUpdates(this);

b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (f == 1) {//dc.setText(String.valueOf(a));
           ;

            Intent I = new Intent(Jmeter.this, display.class);
            I.putExtra("mode", 1);
            I.putExtra("dist", g);
            I.putExtra("cal", k);
            startActivity(I);
            turnGPSOff();


            Jmeter.this.finish();

            /*t.setVisibility(View.INVISIBLE);
            cb.setVisibility(View.INVISIBLE);
            cbc.setVisibility(View.INVISIBLE);
            b.setVisibility(View.INVISIBLE);

          dc.setText("You have run "+g+" Km. \n \n\n\n \n You have burnt "+k+" calories." );
          */
        }else if(gps == 1){
            lat1 = lat;
            lon1 = lon;
            t.setVisibility(View.VISIBLE);
            dc.setVisibility(View.VISIBLE);
            cb.setVisibility(View.VISIBLE);
            cbc.setVisibility(View.VISIBLE);
            b.setText("Stop");
            f = 1;
        }else {
            Toast.makeText(getBaseContext(),"Please turn on your GPS",Toast.LENGTH_LONG).show();
        }

    }
}); Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        String best = locationManager.getBestProvider(criteria, true);
//since you are using true as the second parameter, you will only get
       // the best of providers which are enabled.
                 locationManager.requestLocationUpdates(best, 0, 0, this);
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                0, 0, this);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                0, 0, this);

            //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
//            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
           //locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
        /********* After registration onLocationChanged method  ********/
        /********* called periodically after each 3 sec ***********/
    }

    /************* Called after each 3 sec **********/
    @Override
    public void onLocationChanged(Location location) {


        if(location!=null){
    lat = location.getLatitude();
    lon = location.getLongitude();

    if (lat1 == 0.0 && lon1 == 0.0) {
        lat1 = lat;
        lon1 = lon;


    }


            Double a=0.0;
    a= distance(lat, lon, lat1, lon1, "M");

            l+=(a/100);
    DecimalFormat df = new DecimalFormat("#.##");
    Double i = l * 0.621371;
            TextView t1 = (TextView) findViewById(R.id.tv3);
            try{

            lat1 = lat;
            lon1 = lon;
            c += w * 0.75 * l;

            k = df.format(c);
                if (i.isNaN()){
                    i = 0.0;
                    k = "0";
                }
                g = df.format(i);
                t.setText(g + "  Km");
                t1.setText(k);

                Integer.parseInt(g);
            } catch (Exception e) {
                t.setText("");
                t1.setText("");
                if ( c1 == 0)
                Toast.makeText(getBaseContext(),"Waiting for signal",Toast.LENGTH_SHORT).show();
                c1 = 1;
            }
}

}
    private void turnGPSOn(){
        String provider = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);

        if(!provider.contains("gps")){ //if gps is disabled
            final Intent poke = new Intent();
            poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
            poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
            poke.setData(Uri.parse("3"));
            sendBroadcast(poke);
        }
    }

    private void turnGPSOff(){
        String provider = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);

        if(provider.contains("gps")){ //if gps is enabled
            final Intent poke = new Intent();
            poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
            poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
            poke.setData(Uri.parse("3"));
            sendBroadcast(poke);
        }
    }


    @Override
    public void onProviderDisabled(String provider) {

        /******** Called when User off Gps *********/
        gps = 0;
        //Toast.makeText(getBaseContext(), "Gps turned off ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderEnabled(String provider) {

        /******** Called when User on Gps  *********/
        gps = 1;
        //Toast.makeText(getBaseContext(), "Gps turned on ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }

    public void onBackPressed(){
        Intent intent = new Intent(this,menu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", false);
        startActivity(intent);
        Jmeter.this.finish();

    }

    
    
    
    private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == "K") {
            dist = dist * 1.609344;
        } else if (unit == "N") {
            dist = dist * 0.8684;
        }

        return (dist);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts decimal degrees to radians						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts radians to decimal degrees						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);}







    @Override
    protected void onResume() {
        super.onResume();

    }

}