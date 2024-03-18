package com.example.customer_support_app.Fragment.PageFragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

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

import java.util.ArrayList;


public class PageFragment3 extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ProjectItemModel> projectItemArr = new ArrayList<>();

    public PageFragment3() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_page3, container, false);

        recyclerView = root.findViewById(R.id.recyclerViewPageFragment3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        //================================= Fetching data from API =========================//

        projectItemArr.add(new ProjectItemModel("Sample Project", "Completed", Color.parseColor("#F17175"),
                "Started on: 14th March 2024","Created By: Ritik kumar",
                R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));
        projectItemArr.add(new ProjectItemModel("Sample Project", "Completed",Color.parseColor("#F17175"),
                "Started on: 14th March 2024","Created By: Ritik kumar",
                R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));
        projectItemArr.add(new ProjectItemModel("Sample Project", "Completed",Color.parseColor("#F17175"),
                "Started on: 14th March 2024","Created By: Ritik kumar",
                R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));
        projectItemArr.add(new ProjectItemModel("Sample Project", "Completed",Color.parseColor("#F17175"),
                "Started on: 14th March 2024","Created By: Ritik kumar",
                R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));
        projectItemArr.add(new ProjectItemModel("Sample Project", "Completed",Color.parseColor("#F17175"),
                "Started on: 14th March 2024","Created By: Ritik kumar",
                R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));
        projectItemArr.add(new ProjectItemModel("Sample Project", "Completed",Color.parseColor("#F17175"),
                "Started on: 14th March 2024","Created By: Ritik kumar",
                R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));
        projectItemArr.add(new ProjectItemModel("Sample Project", "Completed",Color.parseColor("#F17175"),
                "Started on: 14th March 2024","Created By: Ritik kumar",
                R.drawable.user_logo,R.drawable.baseline_arrow_forward_ios_24));


        ProjectItemAdapter adapter = new ProjectItemAdapter(requireContext(), projectItemArr);
        adapter.setOnItemClickListener(new ProjectItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(requireContext(), "Projeect Item clicked", Toast.LENGTH_SHORT).show();
                Intent iProjectData = new Intent(requireContext(), ProjectData.class);
                startActivity(iProjectData);
            }
        });
        recyclerView.setAdapter(adapter);
        return root;
    }
}