package com.example.customer_support_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ProjectDataFragment2 extends Fragment {

    public ProjectDataFragment2() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_projecet_data2, container, false);

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_projecet_data2, container, false);

        Spinner spinner = rootView.findViewById(R.id.spinnerId);

        String[] items = {"Backend", "Front end", "Mobile App", "Database"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        return rootView;

    }
}