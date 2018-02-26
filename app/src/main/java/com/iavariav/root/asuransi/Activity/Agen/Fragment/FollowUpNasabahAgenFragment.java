package com.iavariav.root.asuransi.Activity.Agen.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.iavariav.root.asuransi.Activity.Agen.DetailFollowUpActivity;
import com.iavariav.root.asuransi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowUpNasabahAgenFragment extends Fragment {


    private LinearLayout ly;

    public FollowUpNasabahAgenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_follow_up_nasabah, container, false);
        initView(view);

        ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailFollowUpActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void initView(View view) {
        ly = (LinearLayout) view.findViewById(R.id.ly);
    }
}
