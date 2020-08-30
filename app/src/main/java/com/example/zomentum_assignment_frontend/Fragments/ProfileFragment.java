package com.example.zomentum_assignment_frontend.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zomentum_assignment_frontend.R;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.zomentum_assignment_frontend.Activities.HomeScreen.searchView;

public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }

    CircleImageView profilePic;
    TextView profileName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        profilePic = v.findViewById(R.id.profile_pic);
        profileName= v.findViewById(R.id.profile_name);
        profileName.setText("Anne");
        return v;
    }
}