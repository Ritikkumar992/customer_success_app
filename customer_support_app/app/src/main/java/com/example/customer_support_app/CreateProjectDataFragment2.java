package com.example.customer_support_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CreateProjectDataFragment2 extends Fragment {


    public CreateProjectDataFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_create_project_data2, container, false);

        TextView continueBtn = root.findViewById(R.id.continueBtnInviteClient);
        continueBtn.setOnClickListener(v->{
            ViewPager2 viewPager = getActivity().findViewById(R.id.create_project_data_viewPager);
            viewPager.setCurrentItem(2, true);
        });

        TextView backBtn = root.findViewById(R.id.backBtnInviteClient);
        backBtn.setOnClickListener(v->{
            ViewPager2 viewPager = getActivity().findViewById(R.id.create_project_data_viewPager);
            viewPager.setCurrentItem(0, true);
        });

        return root;
    }
}