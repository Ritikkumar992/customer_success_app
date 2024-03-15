package com.example.customer_support_app;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.customer_support_app.Adapter.ExcalationMatrixItemAdapter;
import com.example.customer_support_app.Model.ExcalationMatrixItemModel;
import com.example.customer_support_app.Model.ProjectItemModel;

import java.util.ArrayList;

public class ProjectDataFragment3 extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ExcalationMatrixItemModel> excalationMatrixItemModelsArr = new ArrayList<>();

    public ProjectDataFragment3() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_project_data3, container, false);

        recyclerView = root.findViewById(R.id.recyclerViewExcalationMatrix1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        //================================= Fetching data from API =========================//
        excalationMatrixItemModelsArr.add(new ExcalationMatrixItemModel(R.drawable.user_logo, "Ritik kumar", "Tech Lead", "3"));
        excalationMatrixItemModelsArr.add(new ExcalationMatrixItemModel(R.drawable.user_logo, "Ritik kumar", "Tech Lead", "3"));
        excalationMatrixItemModelsArr.add(new ExcalationMatrixItemModel(R.drawable.user_logo, "Ritik kumar", "Tech Lead", "3"));
        excalationMatrixItemModelsArr.add(new ExcalationMatrixItemModel(R.drawable.user_logo, "Ritik kumar", "Tech Lead", "3"));
        excalationMatrixItemModelsArr.add(new ExcalationMatrixItemModel(R.drawable.user_logo, "Ritik kumar", "Tech Lead", "3"));
        excalationMatrixItemModelsArr.add(new ExcalationMatrixItemModel(R.drawable.user_logo, "Ritik kumar", "Tech Lead", "3"));


        ExcalationMatrixItemAdapter adapter = new ExcalationMatrixItemAdapter(requireContext(), excalationMatrixItemModelsArr);
        recyclerView.setAdapter(adapter);

        return root;
    }
}