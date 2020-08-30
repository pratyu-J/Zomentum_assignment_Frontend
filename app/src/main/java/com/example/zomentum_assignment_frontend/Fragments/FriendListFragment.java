package com.example.zomentum_assignment_frontend.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.zomentum_assignment_frontend.Adapters.FriendsRecyclerAdapter;
import com.example.zomentum_assignment_frontend.Classes.FriendDetailsClass;
import com.example.zomentum_assignment_frontend.R;

import java.util.ArrayList;

import static com.example.zomentum_assignment_frontend.Activities.HomeScreen.searchView;
import static com.example.zomentum_assignment_frontend.Activities.HomeScreen.toolbar;

public class FriendListFragment extends Fragment {


    RecyclerView recyclerView;
    FriendsRecyclerAdapter recyclerAdapter;
    ArrayList<FriendDetailsClass> list = new ArrayList<>();
    public FriendListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_friend_list, container, false);

        recyclerView = v.findViewById(R.id.recycler_friend);
        recyclerView.setHasFixedSize(true);
        fillData();
        recyclerAdapter = new FriendsRecyclerAdapter(getContext(),list , false);
        recyclerView.setAdapter(recyclerAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return v;
    }

    /*@Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }*/


    public void fillData(){
        list.add(new FriendDetailsClass("1", "jojo", "", "offline"));
        list.add(new FriendDetailsClass("1", "becky", "", "offline"));
        list.add(new FriendDetailsClass("1", "adam", "", ""));
        list.add(new FriendDetailsClass("1", "Chris", "", ""));
    }
}