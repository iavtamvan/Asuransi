package com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iavariav.root.asuransi.DetailProfilActivity;
import com.iavariav.root.asuransi.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilUserFragment extends Fragment {

    private CircleImageView ciFoto;

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

        ciFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailProfilActivity.class);
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),ciFoto, ViewCompat.getTransitionName(ciFoto ));
                startActivity(intent, compat.toBundle());
            }
        });
        return view;
    }

    private void initView(View view) {
        ciFoto = (CircleImageView) view.findViewById(R.id.ciFoto);
    }
}
