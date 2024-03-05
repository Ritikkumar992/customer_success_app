package com.example.customer_support_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class CreateProjectDataFragment3 extends Fragment {

    public CreateProjectDataFragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_create_project_data3, container, false);

        View rootView = inflater.inflate(R.layout.fragment_create_project_data3, container, false);

        Spinner spinner = rootView.findViewById(R.id.spinnerId_project_manager);

        String[] items = {"Dipa Majumdar", "Chintak Patel", "Anand Patel","Ritik kumar"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        return rootView;
    }
}