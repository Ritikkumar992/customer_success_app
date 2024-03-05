package com.example.customer_support_app.ui.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.customer_support_app.HomeActivity;
import com.example.customer_support_app.LoginActivity;
import com.example.customer_support_app.ProjectData.ProjectData;
import com.example.customer_support_app.ViewPagerMessengerAdapter;
import com.example.customer_support_app.R;
import com.example.customer_support_app.databinding.FragmentProjectsBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ProjectsFragment extends Fragment {
    TextView createProjectBtn;
    private final String[] titles = {"All Projects", "In Progress", "Completed", "Hold"};

    private TableRow TableRowId;
    private FragmentProjectsBinding binding;

    BottomSheetDialog createProjectBottomDialog;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProjectsViewModel projectsViewModel =
                new ViewModelProvider(this).get(ProjectsViewModel.class);

        binding = FragmentProjectsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        final TextView textView = binding.textProjects;
        projectsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        createProjectBottomDialog = new BottomSheetDialog(requireContext());
        // inflate dialog.
        createDialog();

        createProjectBtn = root.findViewById(R.id.create_project_id);
        createProjectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createProjectBottomDialog.show();
            }
        });

        createProjectBottomDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        //------------------------------------ Pager-----------------   ---------------//
        TabLayout tabLayout = root.findViewById(R.id.tabLayout);
        ViewPager2 viewPager2 = root.findViewById(R.id.viewPager);

        ViewPagerMessengerAdapter adapterClass = new ViewPagerMessengerAdapter(getChildFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapterClass);


        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) ->{
            tab.setText(titles[position]);
        }).attach();


        return root;
    }

    private void createDialog() {
        View view = LayoutInflater.from(requireActivity()).inflate(R.layout.bottom_dialog, null, false);

//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT, // Width
//                ViewGroup.LayoutParams.MATCH_PARENT  // Height
//        );
//        view.setLayoutParams(layoutParams);

        TextView submit = view.findViewById(R.id.continueBtn);
//        EditText name = view.findViewById(R.id.name);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createProjectBottomDialog.dismiss();
                createSecondDialog();
            }
        });
        createProjectBottomDialog = new BottomSheetDialog(requireContext());
        createProjectBottomDialog.setContentView(view);
    }

    private void createSecondDialog() {
        View secondView = getLayoutInflater().inflate(R.layout.second_bottom_dialog, null, false);


        BottomSheetDialog secondBottomDialog = new BottomSheetDialog(requireContext());
        secondBottomDialog.setContentView(secondView);
        secondBottomDialog.show();

        TextView inviteBtn = secondView.findViewById(R.id.inviteBtn);
        inviteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createThirdDialog(); // Call method to create and show the third dialog
                secondBottomDialog.dismiss(); // Dismiss the second dialog
            }
        });
    }

    private void createThirdDialog()
    {
        View thirdView = getLayoutInflater().inflate(R.layout.third_bottom_dialog, null, false);

        BottomSheetDialog thirdBottomDialog = new BottomSheetDialog(requireContext());
        thirdBottomDialog.setContentView(thirdView);
        thirdBottomDialog.show();

        TextView submit = thirdView.findViewById(R.id.submitBtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thirdBottomDialog.dismiss();
                Toast.makeText(getContext(), "NEW PROJECT CREATED ", Toast.LENGTH_SHORT).show();
            }
        });

        //spinnerId_project_manager
        // Initialize the Spinner
        Spinner spinner = thirdView.findViewById(R.id.spinnerId_project_manager);

        // Sample data for the dropdown
        String[] items = {"Dipa Majumdar", "Ritik kumar", "Anand Patel", "Chintak Patel"};

        // Create an ArrayAdapter to populate the Spinner with the sample data
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_spinner_item, items);

        // Set the dropdown layout style
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter to the Spinner
        spinner.setAdapter(adapter);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}