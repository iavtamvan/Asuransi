package com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.iavariav.root.asuransi.Activity.User.ActivityVideo.PendaftaranNasabahKeAgenUserActivity;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.Video.VideoJiwaUserActivity;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.PendaftaranNasabahUserActivity;
import com.iavariav.root.asuransi.Helper.Config;
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
                Bundle bundle = new Bundle();
                bundle.putString(Config.BUNDLE_ID_JENIS_ASURANSI_JIWA, "1");
                Intent intent = new Intent(getActivity(), VideoJiwaUserActivity.class);
                intent.putExtras(intent);
                startActivity(intent);
            }
        });

        divKendaraan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(Config.BUNDLE_ID_JENIS_ASURANSI_KENDARAAN, "2");
                Intent intent = new Intent(getActivity(), VideoJiwaUserActivity.class);
                intent.putExtras(intent);
                startActivity(intent);
            }
        });
        divKesehatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(Config.BUNDLE_ID_JENIS_ASURANSI_KESEHATAN, "3");
                Intent intent = new Intent(getActivity(), VideoJiwaUserActivity.class);
                intent.putExtras(intent);
                startActivity(intent);
            }
        });
        divProperti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(Config.BUNDLE_ID_JENIS_ASURANSI_PROPERTY, "4");
                Intent intent = new Intent(getActivity(), VideoJiwaUserActivity.class);
                intent.putExtras(intent);
                startActivity(intent);
            }
        });
        divLoker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PendaftaranNasabahKeAgenUserActivity.class));
            }
        });

        return view;
    }

    private void initView() {

    }
}
