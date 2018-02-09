package com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.iavariav.root.asuransi.Activity.User.ActivityVideo.Video.VideoJiwaUserActivity;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.PendaftaranAgenUserActivity;
import com.iavariav.root.asuransi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    private LinearLayout divJiwa;
    private LinearLayout divKesehatan;
    private LinearLayout divKendaraan;
    private LinearLayout divProperti;
    private LinearLayout divLoker;

    public static MenuFragment newInstance() {
        MenuFragment fragment = new MenuFragment();
        return fragment;
    }

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        divJiwa = (LinearLayout) view.findViewById(R.id.divJiwa);
        divKesehatan = (LinearLayout) view.findViewById(R.id.divKesehatan);
        divKendaraan = (LinearLayout) view.findViewById(R.id.divKendaraan);
        divProperti = (LinearLayout) view.findViewById(R.id.divProperti);
        divLoker = (LinearLayout) view.findViewById(R.id.divLoker);


        divJiwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), VideoJiwaUserActivity.class));
            }
        });

        divKendaraan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), VideoJiwaUserActivity.class));
            }
        });
        divKesehatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), VideoJiwaUserActivity.class));
            }
        });
        divProperti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), VideoJiwaUserActivity.class));
            }
        });
        divLoker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PendaftaranAgenUserActivity.class));
            }
        });

        return view;
    }

    private void initView() {

    }
}
