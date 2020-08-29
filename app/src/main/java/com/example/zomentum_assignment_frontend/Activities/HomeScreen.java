package com.example.zomentum_assignment_frontend.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.example.zomentum_assignment_frontend.Adapters.ViewPagerAdapter;
import com.example.zomentum_assignment_frontend.Fragments.ChatsFragment;
import com.example.zomentum_assignment_frontend.Fragments.FriendListFragment;
import com.example.zomentum_assignment_frontend.Fragments.ProfileFragment;
import com.example.zomentum_assignment_frontend.R;
import com.google.android.material.tabs.TabLayout;

public class HomeScreen extends AppCompatActivity {

    TextView appName;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        appName = findViewById(R.id.app_name);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void setUpViewPager(ViewPager viewPager){

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FriendListFragment(), "Friends");
        adapter.addFragment(new ChatsFragment(), "Chats");
        adapter.addFragment(new ProfileFragment(), "Profile");
        viewPager.setAdapter(adapter);

    }



}