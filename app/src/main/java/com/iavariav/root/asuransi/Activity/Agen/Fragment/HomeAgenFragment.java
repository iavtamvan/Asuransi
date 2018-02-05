package com.iavariav.root.asuransi.Activity.Agen.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iavariav.root.asuransi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeAgenFragment extends Fragment {
    private LinearLayout div;

    public HomeAgenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        div = (LinearLayout) view.findViewById(R.id.div);
        getdata();
        return view;
    }

    private void getdata() {
        for (int i =0; i<10; i++){
            LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View addView = layoutInflater.inflate(R.layout.row_daftar_nasabah, null);

            final TextView tvAgenNamaNasabah = (TextView) addView.findViewById(R.id.tvAgenNasabahNama);
            final TextView tvAgenNasabahNoID = (TextView) addView.findViewById(R.id.tvAgenNasabahNoID);
            final TextView tvAgenNasabahAlamat = (TextView) addView.findViewById(R.id.tvAgenNasabahAlamat);
            final TextView tvAgenNasabahGolongan = (TextView) addView.findViewById(R.id.tvAgenNasabahGolongan);
            final ImageView ivAgenNasabahFoto = (ImageView) addView.findViewById(R.id.ivAgenNasabahFoto);

            tvAgenNamaNasabah.setText("Ade Fajr Ariav " + i);
            tvAgenNasabahNoID.setText("87435846" + i);
            tvAgenNasabahAlamat.setText("Ungaran " + i);
            tvAgenNasabahGolongan.setText("GOLD " + i);


            div.addView(addView);

        }
    }

}
