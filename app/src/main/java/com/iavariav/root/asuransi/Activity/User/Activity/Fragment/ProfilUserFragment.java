package com.iavariav.root.asuransi.Activity.User.Activity.Fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iavariav.root.asuransi.Activity.User.Activity.DetailProfilUserActivity;
import com.iavariav.root.asuransi.Helper.Config;
import com.iavariav.root.asuransi.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilUserFragment extends Fragment {

    private CircleImageView ciFoto;
    private TextView tvProfilNamaLengkap;
    private TextView tvprofilStatusUser;
    private TextView tvProfilNoHp;
    private TextView tvProfilNIK;
    private TextView tvProfilEmail;

    public static ProfilUserFragment newInstance() {
        ProfilUserFragment fragment = new ProfilUserFragment();
        return fragment;
    }


    public ProfilUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil_user, container, false);
        initView(view);

        SharedPreferences sp = getActivity().getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        tvProfilNamaLengkap.setText(sp.getString(Config.SHARED_FULLNAME,""));
        tvprofilStatusUser.setText(sp.getString(Config.SHARED_STATUS_USER,""));
        tvProfilNoHp.setText("083838191709");
        tvProfilNIK.setText(sp.getString(Config.SHARED_KTP, ""));
        tvProfilEmail.setText(sp.getString(Config.SHARED_EMAIL, ""));
        ciFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailProfilUserActivity.class);
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), ciFoto, ViewCompat.getTransitionName(ciFoto));
                startActivity(intent, compat.toBundle());
            }
        });
        return view;
    }

    private void initView(View view) {
        ciFoto = (CircleImageView) view.findViewById(R.id.ciFoto);
        tvProfilNamaLengkap = (TextView) view.findViewById(R.id.tvProfilNamaLengkap);
        tvprofilStatusUser = (TextView) view.findViewById(R.id.tvprofilStatusUser);
        tvProfilNoHp = (TextView) view.findViewById(R.id.tvProfilNoHp);
        tvProfilNIK = (TextView) view.findViewById(R.id.tvProfilNIK);
        tvProfilEmail = (TextView) view.findViewById(R.id.tvProfilEmail);
    }
}
