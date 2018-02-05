package com.iavariav.root.asuransi.Activity.Agen.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.iavariav.root.asuransi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputNasabahAgenFragment extends Fragment {
    Spinner sp;

    public InputNasabahAgenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_input_nasabah_agen, container, false);

        sp = (Spinner) view.findViewById(R.id.spinners);

        final List<String> list = new ArrayList<String>();
        list.add("Pak");
        list.add("Bu");
        list.add("Mas");
        list.add("Mbak");
        list.add("Om");
        list.add("Tante");


        ArrayAdapter<String> adp = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, list);
        sp.setDropDownHorizontalOffset(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adp);
        return view;
    }

}
