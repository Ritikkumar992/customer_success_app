package com.example.customer_support_app;

import static com.google.common.reflect.Reflection.getPackageName;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customer_support_app.ProjectData.ProjectData;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.common.collect.Table;

import java.util.ArrayList;


public class PageFragment1 extends Fragment {

    ArrayList<TextView> rows = new ArrayList<>();

    public PageFragment1() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_page1, container, false);

        // rows.add(root.findViewById(R.id.rowId1));
        for (int i = 1; i <= 10; i++) {
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
                        Toast.makeText(getContext(), "TableRow clicked", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
        return root;
    }

}