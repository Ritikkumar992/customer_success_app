package com.example.customer_support_app.Fragment.PageFragment;

import static com.google.common.reflect.Reflection.getPackageName;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.customer_support_app.Adapter.ProjectItemAdapter;
import com.example.customer_support_app.Model.ProjectItemModel;
import com.example.customer_support_app.ProjectData.ProjectData;
import com.example.customer_support_app.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;




public class PageFragment1 extends Fragment {

    RecyclerView recyclerView;
    ProjectItemAdapter adapter;

    public PageFragment1() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_page1, container, false);

        recyclerView = root.findViewById(R.id.recyclerViewPageFragment1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        //================================= Fetching data from API =========================//

//        projectItemArr.add(new ProjectItemModel("Sample Project", "Completed", Color.parseColor("#F17175"),
//                "Started on: 14th March 2024","Created By: Ritik kumar",
//                R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));
//
//        projectItemArr.add(new ProjectItemModel("Sample Project", "In Progress",Color.parseColor("#6BE671"),
//                "Started on: 14th March 2024","Created By: Ritik kumar",
//                R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));
//
//        projectItemArr.add(new ProjectItemModel("Sample Project", "Hold",Color.parseColor("#979797"),
//                "Started on: 14th March 2024","Created By: Ritik kumar",
//                R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));
//
//        projectItemArr.add(new ProjectItemModel("Sample Project", "In Progress",Color.parseColor("#6BE671"),
//                "Started on: 14th March 2024","Created By: Ritik kumar",
//                R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));
//        projectItemArr.add(new ProjectItemModel("Sample Project", "Completed", Color.parseColor("#F17175"),
//                "Started on: 14th March 2024","Created By: Ritik kumar",
//                R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));
//
//        projectItemArr.add(new ProjectItemModel("Sample Project", "In Progress",Color.parseColor("#6BE671"),
//                "Started on: 14th March 2024","Created By: Ritik kumar",
//                R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));
//
//        projectItemArr.add(new ProjectItemModel("Sample Project", "Hold",Color.parseColor("#979797"),
//                "Started on: 14th March 2024","Created By: Ritik kumar",
//                R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));
//
//        projectItemArr.add(new ProjectItemModel("Sample Project", "In Progress",Color.parseColor("#6BE671"),
//                "Started on: 14th March 2024","Created By: Ritik kumar",
//                R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));


        //======================================== Read Operation :  Fetching Data from Firebase ======================//
        FirebaseRecyclerOptions<ProjectItemModel> options =
                new FirebaseRecyclerOptions.Builder<ProjectItemModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("createProjectTable"), ProjectItemModel.class)
                        .build();

        adapter = new ProjectItemAdapter(options);
        recyclerView.setAdapter(adapter);


        return root;
    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}