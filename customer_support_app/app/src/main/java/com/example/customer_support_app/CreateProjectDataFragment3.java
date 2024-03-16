package com.example.customer_support_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class CreateProjectDataFragment3 extends Fragment {

    TextView SubmitBtn, backBtn;

    public CreateProjectDataFragment3() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_create_project_data3, container, false);



        // SUBMIT BUTTON CLICKED:
        SubmitBtn = rootView.findViewById(R.id.submitBtn);
        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), HomeActivity.class);
                startActivity(intent);
                Toast.makeText(requireContext(), "New Project Added", Toast.LENGTH_SHORT).show();
            }
        });

        backBtn = rootView.findViewById(R.id.backBtn);
        backBtn.setOnClickListener(v->{
            ViewPager2 viewPager = getActivity().findViewById(R.id.create_project_data_viewPager);
            viewPager.setCurrentItem(1, true);
        });



        Spinner spinner = rootView.findViewById(R.id.spinnerId_project_manager);

        String[] items = {"Dipa Majumdar", "Chintak Patel", "Anand Patel","Ritik kumar"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        return rootView;
    }
}