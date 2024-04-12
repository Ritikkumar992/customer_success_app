package com.example.customer_support_app.Fragment.PageFragment;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.customer_support_app.Adapter.ProjectItemAdapter;
import com.example.customer_support_app.Model.ProjectItemModel;
import com.example.customer_support_app.ProjectData.ProjectData;
import com.example.customer_support_app.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PageFragment2 extends Fragment {

    RecyclerView recyclerView;
    ProjectItemAdapter adapter;
    ArrayList<ProjectItemModel> projectItemModelsArr = new ArrayList<>();

    DatabaseReference database;

    public PageFragment2() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_page2, container, false);

        recyclerView = root.findViewById(R.id.recyclerViewPageFragment2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        //================================= Fetching data from API =========================//
        projectItemArr.add(new ProjectItemModel("Dump Project", "In Progess",
                "Started on: 15th March 2024","Created By: Ritik kumar", R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));
//        projectItemArr.add(new ProjectItemModel("Dump Project", "In Progess", Color.parseColor("#6BE671"),
//                "Started on: 15th March 2024","Created By: Ritik kumar", R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));
//        projectItemArr.add(new ProjectItemModel("Dump Project", "In Progess",Color.parseColor("#6BE671"),
//                "Started on: 15th March 2024","Created By: Ritik kumar", R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));
//        projectItemArr.add(new ProjectItemModel("Dump Project", "In Progess", Color.parseColor("#6BE671"),
//                "Started on: 15th March 2024","Created By: Ritik kumar", R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));



<<<<<<< HEAD
        ProjectItemAdapter adapter = new ProjectItemAdapter(requireContext(), projectItemArr);
=======
//        ProjectItemAdapter adapter = new ProjectItemAdapter(requireContext(), projectItemArr);
//        adapter.setOnItemClickListener(new ProjectItemAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                Toast.makeText(requireContext(), "Projeect Item clicked", Toast.LENGTH_SHORT).show();
//                Intent iProjectData = new Intent(requireContext(), ProjectData.class);
//                startActivity(iProjectData);
//            }
//        });
//        recyclerView.setAdapter(adapter);

        recyclerView = root.findViewById(R.id.recyclerViewPageFragment2);

        database = FirebaseDatabase.getInstance().getReference("createProjectTable");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        adapter = new ProjectItemAdapter(requireContext(), projectItemModelsArr);

>>>>>>> 25e473b50d679d3fc60d26e2bfa002a80216cb0f
        adapter.setOnItemClickListener(new ProjectItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(requireContext(), "Projeect Item clicked", Toast.LENGTH_SHORT).show();
                Intent iProjectData = new Intent(requireContext(), ProjectData.class);
                startActivity(iProjectData);
            }
        });
<<<<<<< HEAD
        recyclerView.setAdapter(adapter);
=======

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


>>>>>>> 25e473b50d679d3fc60d26e2bfa002a80216cb0f
        return root;
    }
}