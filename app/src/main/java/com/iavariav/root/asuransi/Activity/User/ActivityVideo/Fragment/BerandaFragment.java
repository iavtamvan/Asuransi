package com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment.ServiceMaps.GPSTracker;
import com.iavariav.root.asuransi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaFragment extends Fragment implements OnMapReadyCallback{
    private MapView mapV;
    GPSTracker gpsTracker;
    private double Lat,Long;

    public static BerandaFragment newInstance() {
        BerandaFragment fragment = new BerandaFragment();
        return fragment;
    }

    public BerandaFragment() {
        // Required empty public constructor
    }

    private GoogleMap mMap;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        mapV = (MapView) view.findViewById(R.id.maps);
        mapV.onCreate(savedInstanceState);
        mapV.onResume();

        gpsTracker = new GPSTracker(getActivity());
        if (gpsTracker.canGetLocation()){
            Lat = gpsTracker.getLatitude();
            Long = gpsTracker.getLongitude();
            Toast.makeText(getActivity(), "lat : " + Lat + "Long :  " + Long, Toast.LENGTH_SHORT).show();
        } else {
            gpsTracker.showSettingsAlert();
        }

        try {
            MapsInitializer.initialize(getActivity());
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15));

        } catch (Exception e) {
            e.printStackTrace();
        }

        mapV.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;

                BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.star);
                BitmapDescriptor silver = BitmapDescriptorFactory.fromResource(R.drawable.silver);
                BitmapDescriptor brows = BitmapDescriptorFactory.fromResource(R.drawable.brows);
                LatLng user = new LatLng(-6.9827841,110.4092904);
//                LatLng hermina = new LatLng(-7.0247246, 110.3820431);

                mMap.moveCamera(CameraUpdateFactory.newLatLng(user));
                if (ActivityCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                mMap.setMyLocationEnabled(true);
//                LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
//                Criteria criteria = new Criteria();
//                Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));


//                gpsTracker = new GPSTracker(getActivity());
//                double lat = gpsTracker.getLatitude();
//                double lng = gpsTracker.getLongitude();
//                Toast.makeText(getActivity(), "lat : " + lat + "long : " + lng, Toast.LENGTH_SHORT).show();
                // Zoom in the Google Map
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));
//                LatLng sydney = new LatLng(-34, 151);
//                mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-7.0247246, 110.3820431))
                        .title("Agen Hermina")
                        .snippet("gold")
                        .icon(icon));


                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-6.987714,110.408473))
                        .title("Agen Pelangi")
                        .snippet("gold")
                        .icon(icon));

                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-7.0399922,110.3525043))
                        .title("Agen Kreo")
                        .snippet("Silver")
                        .icon(silver));

                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-6.9827841,110.4092904))
                        .title("Agen Udinus")
                        .snippet("gold")
                        .icon(icon));



                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng( -6.9824107,110.4087848))
                        .title("Agen Tugu")
                        .snippet("Silver")
                        .icon(silver));

                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-6.9829938,110.4095841))
                        .title("Agen Sewu")
                        .snippet("Platinum")
                        .icon(brows));



            }
        });

        return view ;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        
    }
}
