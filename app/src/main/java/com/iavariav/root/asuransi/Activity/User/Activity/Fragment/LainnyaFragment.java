package com.iavariav.root.asuransi.Activity.User.Activity.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.iavariav.root.asuransi.Activity.User.Activity.HistoryActivity;
import com.iavariav.root.asuransi.Activity.User.Activity.ProfilActivity;
import com.iavariav.root.asuransi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LainnyaFragment extends Fragment {


    private CardView cardProfil;
    private CardView cardHistory;
    private FrameLayout lainnya;

    public static LainnyaFragment newInstance() {
        LainnyaFragment fragment = new LainnyaFragment();
        return fragment;
    }

    public LainnyaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lainnya, container, false);
        initView(view);


        cardProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                startActivity(intent);
            }
        });
        cardHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HistoryActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void initView(View view) {
        cardProfil = (CardView) view.findViewById(R.id.card_profil);
        cardHistory = (CardView) view.findViewById(R.id.card_history);
        lainnya = (FrameLayout) view.findViewById(R.id.lainnya);
    }
}
