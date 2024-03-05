package com.example.customer_support_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customer_support_app.ProjectData.ProjectData;

import java.util.ArrayList;


public class PageFragment4 extends Fragment {
    ArrayList<TextView> rows = new ArrayList<>();
    public PageFragment4() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_page4, container, false);

        for (int i = 1; i <= 7; i++) {
            int textViewId = getResources().getIdentifier("rowId" + i, "id", requireActivity().getPackageName());
            TextView textView = root.findViewById(textViewId);
            rows.add(textView);
        }
        for(int i = 0;i<rows.size();i++){
            if(rows.get(i) != null){
                rows.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent iProjectData = new Intent(requireContext(), ProjectData.class);
                        startActivity(iProjectData);
                        Toast.makeText(getContext(), "In Hold TableRow clicked", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
        return root;
    }
}