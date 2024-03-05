package com.example.customer_support_app.ProjectData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.customer_support_app.R;
import com.example.customer_support_app.ViewPagerMessengerAdapter;
import com.example.customer_support_app.ViewProjectDataAdapter;
import com.example.customer_support_app.ui.project.ProjectsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ProjectData extends AppCompatActivity {
    private final String[] titles = {"Project Overview", "Scope & Stack", "Escalation Matrix", "Version History", "Files"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_data);

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

        //------------------------------------ Pager-------------------------------//
        TabLayout tabLayout = findViewById(R.id.project_tabLayout);
        ViewPager2 viewPager2 = findViewById(R.id.project_data_viewPager);

        // accessing ViewProjectDataAdapter.java class to attach adapter to fetch data.
        ViewProjectDataAdapter adapterClass = new ViewProjectDataAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapterClass);


        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) ->{
            tab.setText(titles[position]);
        }).attach();

//        //----------------------------- WORKING WITH BOTTOM NAVIGATION BAR----------------------------//
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
//        @SuppressLint("MissingInflatedId") MenuItem home = findViewById(R.id.home);
//
//        bottomNavigationView.getTransitionName(new BottomNavigationView())

    }
}