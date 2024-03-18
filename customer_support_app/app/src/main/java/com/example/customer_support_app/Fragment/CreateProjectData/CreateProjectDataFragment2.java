package com.example.customer_support_app.Fragment.CreateProjectData;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customer_support_app.Firebase.FirebaseResourse;
import com.example.customer_support_app.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class CreateProjectDataFragment2 extends Fragment {
    FirebaseResourse firebaseResourse = new FirebaseResourse();

    EditText clientNameView, clientEmailView;
    TextView addClient,backBtn, continueBtn;
    String clientName, clientEmail;
    public CreateProjectDataFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_create_project_data2, container, false);

        clientNameView = root.findViewById(R.id.clientNameId);
        clientEmailView = root.findViewById(R.id.clientEmailId);
        addClient = root.findViewById(R.id.addClient);
        continueBtn = root.findViewById(R.id.sendBtnInviteClient);
        backBtn = root.findViewById(R.id.backBtnInviteClient);

        addClient.setOnClickListener(v->{
            clientName = clientNameView.getText().toString();
            clientEmail = clientEmailView.getText().toString();

            clearAll();
            navigateNext();
        });

        continueBtn.setOnClickListener(v->{
            navigateNext();
        });


        backBtn.setOnClickListener(v->{
           navigatePrev();
        });

        return root;
    }

    private void clearAll()
    {
        clientNameView.setText("");
        clientEmailView.setText("");
    }
    private void navigateNext()
    {
        ViewPager2 viewPager = getActivity().findViewById(R.id.create_project_data_viewPager);
        viewPager.setCurrentItem(2, true);
    }
    private void navigatePrev()
    {
        ViewPager2 viewPager = getActivity().findViewById(R.id.create_project_data_viewPager);
        viewPager.setCurrentItem(0, true);
    }
}