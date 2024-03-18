package com.example.customer_support_app.Fragment.CreateProjectData;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.customer_support_app.R;

public class CreateProjectDataFragment1 extends Fragment {

    public CreateProjectDataFragment1() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root =  inflater.inflate(R.layout.fragment_create_project_data1, container, false);

        TextView continueBtn = root.findViewById(R.id.continueBtnProjectName);
        continueBtn.setOnClickListener(v->{
            ViewPager2 viewPager = getActivity().findViewById(R.id.create_project_data_viewPager);
            viewPager.setCurrentItem(1, true);
        });
        return root;
    }

}