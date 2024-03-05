package com.example.customer_support_app.createProject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;

import com.example.customer_support_app.R;
import com.example.customer_support_app.ViewProjectDataAdapter;
import com.example.customer_support_app.createProjectDataAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class createProjectActivity extends AppCompatActivity {

    private final String[] titles = {"Project Details", "Invite Client","Select Project Manager"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project);

        // remove title bar
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            WindowInsetsController windowInsetsController = getWindow().getInsetsController();
            if(windowInsetsController != null){
                windowInsetsController.hide(WindowInsets.Type.statusBars());
            }
        }
        else{
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        //------------------------------------Pager-------------------------------//
        TabLayout tabLayout = findViewById(R.id.create_project_tabLayout);
        ViewPager2 viewPager2 = findViewById(R.id.create_project_data_viewPager);

//         accessing createProjectDataAdapter.java class to attach adapter to fetch data.
        createProjectDataAdapter adapterClass = new createProjectDataAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapterClass);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) ->{
            tab.setText(titles[position]);
        }).attach();

    }
}