package com.example.customer_support_app.Fragment.PageFragment;

import static com.google.common.reflect.Reflection.getPackageName;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.customer_support_app.Adapter.ProjectItemAdapter;
import com.example.customer_support_app.Firebase.FirebaseResourse;
import com.example.customer_support_app.Model.ProjectItemModel;
import com.example.customer_support_app.ProjectData.ProjectData;
import com.example.customer_support_app.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class PageFragment1 extends Fragment {

    RecyclerView recyclerView;
    ProjectItemAdapter adapter;
    ArrayList<ProjectItemModel> projectItemModelsArr = new ArrayList<>();

    DatabaseReference database;

    public PageFragment1() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_page1, container, false);




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

        recyclerView = root.findViewById(R.id.recyclerViewPageFragment1);

        database = FirebaseDatabase.getInstance().getReference("createProjectTable");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        adapter = new ProjectItemAdapter(requireContext(), projectItemModelsArr);

        adapter.setOnItemClickListener(new ProjectItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(requireContext(), "Project Item clicked", Toast.LENGTH_SHORT).show();
                Intent iProjectData = new Intent(requireContext(), ProjectData.class);
                startActivity(iProjectData);
            }
        });

        recyclerView.setAdapter(adapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                projectItemModelsArr.clear(); // Clear the list before adding new items
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ProjectItemModel projectItem = dataSnapshot.getValue(ProjectItemModel.class);
                    projectItemModelsArr.add(0,projectItem);
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle cancellation
            }
        });
        return root;
    }
}