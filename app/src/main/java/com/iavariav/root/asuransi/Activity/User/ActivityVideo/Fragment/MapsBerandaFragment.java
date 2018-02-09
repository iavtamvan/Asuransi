package com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment.ServiceMaps.GPSTracker;
import com.iavariav.root.asuransi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapsBerandaFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    Double Lat, Long;
    GPSTracker gpsTracker;

    public MapsBerandaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_maps_beranda, container, false);
        gpsTracker = new GPSTracker(getActivity());
        if (gpsTracker.canGetLocation()){
            Lat = gpsTracker.getLatitude();
            Long = gpsTracker.getLongitude();
            LatLng sydney = new LatLng(Lat, Long);
            Toast.makeText(getActivity(), "Loc " + sydney, Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), "lat : " + Lat + "Long :  " + Long, Toast.LENGTH_SHORT).show();

        } else {
            gpsTracker.showSettingsAlert();
        }
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(Lat, Long);
        Toast.makeText(getActivity(), "" , Toast.LENGTH_SHORT).show();
        mMap.addMarker(new MarkerOptions().position(sydney).title("Posisi" + Lat + Long));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
