package com.example.zomentum_assignment_frontend.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;


import com.example.zomentum_assignment_frontend.Adapters.ViewPagerAdapter;
import com.example.zomentum_assignment_frontend.Fragments.ChatsFragment;
import com.example.zomentum_assignment_frontend.Fragments.FriendListFragment;
import com.example.zomentum_assignment_frontend.Fragments.ProfileFragment;
import com.example.zomentum_assignment_frontend.R;
import com.google.android.material.tabs.TabLayout;

public class HomeScreen extends AppCompatActivity {

    TextView appName;
    public static Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    public static SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        appName = findViewById(R.id.app_name);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("zomentum");

        searchView = findViewById(R.id.search);
        searchView.setVisibility(View.VISIBLE);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.help :
                Toast.makeText(HomeScreen.this,  "Help", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Toast.makeText(HomeScreen.this,  "Logout", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setUpViewPager(ViewPager viewPager){

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FriendListFragment(), "Friends");
        adapter.addFragment(new ChatsFragment(), "Chats");
        adapter.addFragment(new ProfileFragment(), "Profile");
        viewPager.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        }

        finish();
    }
}