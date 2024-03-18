package com.example.customer_support_app.Fragment.CreateProjectData;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customer_support_app.Activity.HomeActivity;
import com.example.customer_support_app.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class CreateProjectDataFragment3 extends Fragment {

    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String currentDate = dateFormat.format(date);
    Spinner spinner;
    TextView submitBtn, backBtn;
    CreateProjectDataFragment1 createProjectDataFragment1;
    String projectManagerName, projectName, clientName, clientEmail;


    public CreateProjectDataFragment3() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_create_project_data3, container, false);

        spinner = root.findViewById(R.id.spinnerId_project_manager);
        submitBtn = root.findViewById(R.id.submitBtn);
        backBtn = root.findViewById(R.id.backBtn);



        submitBtn.setOnClickListener(v -> {
            insertAllData();
            navigateHome();
            Toast.makeText(requireContext(), "New Project Added", Toast.LENGTH_SHORT).show();
        });
        backBtn.setOnClickListener(v->{
            navigatePrev();
        });


        setSpinner();
        return root;
    }

    private void insertAllData()
    {
        Map<String, Object> map = new HashMap<>();

        map.put("projectName",projectName);

        map.put("projectStatus","In Progress");
        map.put("projectStatusBg", "#" + Integer.toHexString(Color.parseColor("#6BE671")));
        map.put("projectStartDate",currentDate);

        map.put("clientName",clientName);
        map.put("clientEmail",clientEmail);


        map.put("projectManagerImg", R.drawable.ic_launcher_foreground);
        map.put("projectManagerName",projectManagerName);

        FirebaseDatabase.getInstance().getReference().child("createProjectTable")
                .push().setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(requireContext(),"Data Inserted Successfully ", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    Log.e("ERROR", e.toString());
                    Toast.makeText(requireContext(),"Data Inserted Failed ", Toast.LENGTH_SHORT).show();
                });
    }

    private void setSpinner()
    {
        String[] items = {"Dipa Majumdar", "Chintak Patel", "Anand Patel","Ritik kumar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                projectManagerName = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(requireContext(), "Please Select an item", Toast.LENGTH_SHORT).show();
            }
        });
        spinner.setAdapter(adapter);
    }
    private void navigateHome(){
        Intent intent = new Intent(requireContext(), HomeActivity.class);
        startActivity(intent);
    }private void navigatePrev(){
        ViewPager2 viewPager = getActivity().findViewById(R.id.create_project_data_viewPager);
        viewPager.setCurrentItem(1, true);
    }
}