package com.example.customer_support_app.Fragment.PageFragment;

import java.util.List;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.customer_support_app.Adapter.ProjectItemAdapter;
import com.example.customer_support_app.EndPoints.Api;
import com.example.customer_support_app.Model.ProjectItemModel;
import com.example.customer_support_app.Network.RetrofitClient;
import com.example.customer_support_app.R;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PageFragment1 extends Fragment {

    RecyclerView recyclerView;
    ProjectItemAdapter adapter;
    List<ProjectItemModel> projectItemModelsArr = new ArrayList<>();

    DatabaseReference database;

    public PageFragment1() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_page1, container, false);

        //================================= Fetching data from API =========================//

        Call<List<ProjectItemModel>> call = new RetrofitClient().getRetrofitInstance().create(Api.class).getProjects("Admin","auth0|660ea1d651aa90d60be5a6bd");
        call.enqueue(new Callback<List<ProjectItemModel>>() {
            @Override
            public void onResponse(Call<List<ProjectItemModel>> call, Response<List<ProjectItemModel>> response) {

                List<ProjectItemModel> projectDataList = response.body();
                if (response.isSuccessful() && !projectDataList.isEmpty()) {

                    recyclerView = root.findViewById(R.id.recyclerViewPageFragment1);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
                    adapter = new ProjectItemAdapter(requireContext(), projectDataList);
                    recyclerView.setAdapter(adapter);

<<<<<<< HEAD
                } else {
                    Log.e("ERROR", response.message());
=======
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
>>>>>>> 25e473b50d679d3fc60d26e2bfa002a80216cb0f
                }
            }
            @Override
<<<<<<< HEAD
            public void onFailure(Call<List<ProjectItemModel>> call, Throwable t) {
                Log.e("ERROR",t.getMessage());
=======
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle cancellation
>>>>>>> 25e473b50d679d3fc60d26e2bfa002a80216cb0f
            }
        });
        return root;
    }
}