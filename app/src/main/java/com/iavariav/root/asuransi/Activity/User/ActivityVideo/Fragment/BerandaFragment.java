package com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment;


import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
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
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment.ServiceMaps.GPSTracker;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.HomeUserActivity;
import com.iavariav.root.asuransi.Helper.Config;
import com.iavariav.root.asuransi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaFragment extends Fragment implements
        OnMapReadyCallback, GoogleMap.OnPoiClickListener{
    private MapView mapV;
    GPSTracker gpsTracker;
    private double Lat, Long;
    private GoogleMap mMap;
//    private Polyline mMutablePolyline;



//    private static final LatLng ADELAIDE = new LatLng(-34.92873, 138.59995);
//    private static final LatLng DARWIN = new LatLng(-12.4258647, 130.7932231);
//    private static final LatLng MELBOURNE = new LatLng(-37.81319, 144.96298);
//    private static final LatLng PERTH = new LatLng(-31.95285, 115.85734);
//
//
//    private static final LatLng AKL = new LatLng(-37.006254, 174.783018);
//    private static final LatLng JFK = new LatLng(40.641051, -73.777485);
//    private static final LatLng LAX = new LatLng(33.936524, -118.377686);
//    private static final LatLng LHR = new LatLng(51.471547, -0.460052);




    public static BerandaFragment newInstance() {
        BerandaFragment fragment = new BerandaFragment();
        return fragment;
    }

    public BerandaFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        mapV = (MapView) view.findViewById(R.id.maps);
        mapV.onCreate(savedInstanceState);
        mapV.onResume();

        gpsTracker = new GPSTracker(getActivity());
        if (gpsTracker.canGetLocation()) {
            Lat = gpsTracker.getLatitude();
            Long = gpsTracker.getLongitude();
            MapsInitializer.initialize(getActivity());
            Toast.makeText(getActivity(), "" + Lat + Long,  Toast.LENGTH_SHORT).show();
//            mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        } else {
            gpsTracker.showSettingsAlert();
        }


        mapV.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;

                BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.star);
                BitmapDescriptor silver = BitmapDescriptorFactory.fromResource(R.drawable.silver);
                BitmapDescriptor brows = BitmapDescriptorFactory.fromResource(R.drawable.brows);
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                ;
                LatLng user = new LatLng(Lat,Long);
//                LatLng hermina = new LatLng(-7.0247246, 110.3820431);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(user));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(Config.ZOOM_TO_LEVEL));
                //                mMap.addCircle(new CircleOptions()
//                .center(user).radius(Config.RADIOUS_TO_LEVEL));
//                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); // klo di hilangin jadi biasa aja
                mMap.setMyLocationEnabled(true);

//                mMap.addPolyline(new PolylineOptions()
//                .add(user, AKL)
//                .color(Color.BLUE));

//                mMutablePolyline = mMap.addPolyline(new PolylineOptions()
//                .color(Color.RED)
//                        .width(5)
//                .add(new LatLng(-7.0051450, 110.4381250),
//                        new LatLng(-7.18 , 110.33),
//                        new LatLng(-7.7955800, 110.3694900),
//                        new LatLng(-7.0051450, 110.4381250))
//                .geodesic(true)
//                        .visible(true));


                // Zoom in the Google Map
//                googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));
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
            }
        });


        PolylineOptions polylineOptions = new PolylineOptions()
                .add(new LatLng(Lat, Long))
                .add(new LatLng(-7.0399922,110.3525043));
//        Polyline polyline = mMap.addPolyline(polylineOptions);
//        polyline

        return view ;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(Lat, Long);
        Toast.makeText(gpsTracker, "Berhasil : " + sydney, Toast.LENGTH_SHORT).show();
        mMap.addMarker(new MarkerOptions().position(sydney).title("Posisi" + Lat + Long));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


    @Override
    public void onPoiClick(PointOfInterest pointOfInterest) {
        Toast.makeText(getActivity(), "Clicked: " +
                        pointOfInterest.name + "\nPlace ID:" + pointOfInterest.placeId +
                        "\nLatitude:" + pointOfInterest.latLng.latitude +
                        " Longitude:" + pointOfInterest.latLng.longitude,
                Toast.LENGTH_SHORT).show();
    }
}
