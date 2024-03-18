package com.example.customer_support_app.Fragment.CreateProjectData;

import com.example.customer_support_app.Firebase.FirebaseResourse;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customer_support_app.R;


public class CreateProjectDataFragment1 extends Fragment {
    FirebaseResourse firebaseResourse = new FirebaseResourse();
    TextView continueBtn;
    EditText projectNameView;

    private String projectName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root =  inflater.inflate(R.layout.fragment_create_project_data1, container, false);

        continueBtn = root.findViewById(R.id.continueBtnProjectName);
        projectNameView = root.findViewById(R.id.projectNameId);

        continueBtn.setOnClickListener(v->{
            projectName = projectNameView.getText().toString();
            clearAll();
            navigateNext();
        });
        return root;
    }
    private void clearAll()
    {
        projectNameView.setText("");
    }
    private void navigateNext()
    {
        Toast.makeText(requireContext(), projectName,Toast.LENGTH_SHORT).show();
        ViewPager2 viewPager = getActivity().findViewById(R.id.create_project_data_viewPager);
        viewPager.setCurrentItem(1, true);
    }

    public String getProjectName(){
        return projectName;
    }

}