package com.example.customer_support_app.Fragment.CreateProjectData;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
<<<<<<< HEAD
=======
import androidx.lifecycle.Observer;
>>>>>>> 25e473b50d679d3fc60d26e2bfa002a80216cb0f
import androidx.lifecycle.ViewModelProvider;
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
import androidx.lifecycle.Observer;

import com.example.customer_support_app.Activity.HomeActivity;
<<<<<<< HEAD
import com.example.customer_support_app.EndPoints.Api;
import com.example.customer_support_app.Model.CreateProjectModel;
import com.example.customer_support_app.Model.CreateProjectViewModel;
import com.example.customer_support_app.Model.ManagerListModel;
import com.example.customer_support_app.Network.RetrofitClient;
=======
import com.example.customer_support_app.Model.CreateProjectViewModel;
>>>>>>> 25e473b50d679d3fc60d26e2bfa002a80216cb0f
import com.example.customer_support_app.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CreateProjectDataFragment3 extends Fragment {

    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String currentDate = dateFormat.format(date);
    Spinner spinner;
    TextView submitBtn, backBtn;
    CreateProjectDataFragment1 createProjectDataFragment1;
    String projectManagerName, projectName, clientName, clientEmail;
<<<<<<< HEAD
    int projectManagerUserId;
    private CreateProjectViewModel viewModel;
=======

    private CreateProjectViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(CreateProjectViewModel.class);
    }

>>>>>>> 25e473b50d679d3fc60d26e2bfa002a80216cb0f

    public CreateProjectDataFragment3() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(CreateProjectViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_create_project_data3, container, false);

        spinner = root.findViewById(R.id.spinnerId_project_manager);
        submitBtn = root.findViewById(R.id.submitBtn);
        backBtn = root.findViewById(R.id.backBtn);

        // Observe  LiveData

        viewModel.getProjectNameLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                projectName = s;
            }
        });

        viewModel.getClientNameLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String name) {
                clientName = name;
            }
        });
        viewModel.getClientEmailLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String email) {
                clientEmail = email;
            }
        });

        // Observe  LiveData

        viewModel.getProjectNameLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                projectName = s;
            }
        });

        viewModel.getClientNameLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String name) {
                clientName = name;
            }
        });
        viewModel.getClientEmailLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String email) {
                clientEmail = email;
            }
        });

        submitBtn.setOnClickListener(v -> {
            insertData(); // API Call to POST data the backend
            navigateHome();
            Toast.makeText(requireContext(), "New Project Added", Toast.LENGTH_SHORT).show();
        });
        backBtn.setOnClickListener(v->{
            navigatePrev();
        });

        setSpinner();  // getting the manager list using api.

        return root;
    }
    private void insertData()
    {
<<<<<<< HEAD
        CreateProjectModel project = new CreateProjectModel();
        project.set_id(String.valueOf(Math.random()));
        project.setName(projectName);

        CreateProjectModel.AssociatedManager associatedManager = new CreateProjectModel.AssociatedManager(String.valueOf(Math.random()),projectName,"Manager");
        associatedManager.set_id(String.valueOf(projectManagerUserId));
        associatedManager.setName(projectManagerName);
        associatedManager.setDesignation("Manager");
        project.setAssociated_manager(associatedManager);

        project.setStatus("On-Going");
        project.setStart_date(currentDate);

        Call<List<CreateProjectModel>> call = new RetrofitClient().getRetrofitInstance().create(Api.class).createProject(project);
        call.enqueue(new Callback<List<CreateProjectModel>>() {
            @Override
            public void onResponse(Call<List<CreateProjectModel>> call, Response<List<CreateProjectModel>> response) {
                if(response.isSuccessful()){
                    Log.e("LOGGGGGGGG:","Data added successfully");
                }
            }
            @Override
            public void onFailure(Call<List<CreateProjectModel>> call, Throwable t) {
                Log.e("FAIL:",t.getMessage());
            }
        });
=======
        Map<String, Object> map = new HashMap<>();

        map.put("projectName", projectName);
        map.put("projectStatus","In Progress");

        map.put("projectStatusBg", "#6BE671");

        map.put("projectStartDate","Start Date: "+currentDate);
        map.put("clientName",clientName);
        map.put("clientEmail",clientEmail);
        map.put("projectManagerImg", R.drawable.profile_logo3);
        map.put("projectManagerName","Created by: " + projectManagerName);


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
>>>>>>> 25e473b50d679d3fc60d26e2bfa002a80216cb0f
    }


    /** Manager List (GET)
     * rol_id: rol_qLO42FIvSNsdZEO4
     */

    private void setSpinner()
    {
<<<<<<< HEAD
        // create handler for retrofit handle instance
        Call<List<ManagerListModel>> call = new RetrofitClient()
                .getRetrofitInstance()
                .create(Api.class)
                .getManagers();
        call.enqueue(new Callback<List<ManagerListModel>>() {
=======
        String[] items = {"Dipa Majumdar", "Chintak Patel", "Anand Patel","Ritik kumar", "Rohan Manna"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
>>>>>>> 25e473b50d679d3fc60d26e2bfa002a80216cb0f
            @Override
            public void onResponse(Call<List<ManagerListModel>> call, Response<List<ManagerListModel>> response) {
                String[] managerNames = new String[response.body().size()];
                if (response.isSuccessful() && response.body() != null) {
                    List<ManagerListModel> managers = response.body();
                    for (int i = 0; i < managers.size(); i++) {
                        ManagerListModel manager = managers.get(i);
                        managerNames[i] = manager.getName();
                    }

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, managerNames);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        projectManagerName = parent.getItemAtPosition(position).toString();
                        projectManagerUserId = parent.getId();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(requireContext(), "Please Select an item", Toast.LENGTH_SHORT).show();
                    }
                });

                spinner.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<List<ManagerListModel>> call, Throwable t) {
                Log.e("FAILLLLLLLLLLLLLLLLL","SADDDDDDDDDDDDDDDDDDDDDDDDDD:(");
                Log.e("ERROR", t.getMessage());
                Toast.makeText(requireContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void navigateHome(){
        Intent intent = new Intent(requireContext(), HomeActivity.class);
        startActivity(intent);
    }
    private void navigatePrev(){
        ViewPager2 viewPager = getActivity().findViewById(R.id.create_project_data_viewPager);
        viewPager.setCurrentItem(1, true);
    }
}