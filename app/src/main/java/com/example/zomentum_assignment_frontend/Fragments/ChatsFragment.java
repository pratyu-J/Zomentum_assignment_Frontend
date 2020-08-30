package com.example.zomentum_assignment_frontend.Fragments;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zomentum_assignment_frontend.Adapters.FriendsRecyclerAdapter;
import com.example.zomentum_assignment_frontend.Adapters.RecentRecyclerAdapter;
import com.example.zomentum_assignment_frontend.Classes.FriendDetailsClass;
import com.example.zomentum_assignment_frontend.R;

import java.util.ArrayList;

import static com.example.zomentum_assignment_frontend.Activities.HomeScreen.searchView;
import static com.example.zomentum_assignment_frontend.Activities.HomeScreen.toolbar;


public class ChatsFragment extends Fragment {

    RecyclerView recyclerView;
    RecentRecyclerAdapter recyclerAdapter;
    ArrayList<FriendDetailsClass> list = new ArrayList<>();
    public ChatsFragment() {
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
        View v = inflater.inflate(R.layout.fragment_chats, container, false);

        recyclerView = v.findViewById(R.id.recent_chats);
        recyclerView.setHasFixedSize(true);
        fillData();
        recyclerAdapter = new RecentRecyclerAdapter(getContext(),list , true);
        recyclerView.setAdapter(recyclerAdapter);
        return v;
    }

    public void fillData() {

        list.clear();

        list.add(new FriendDetailsClass("1", "becky", "", "offline"));
        list.add(new FriendDetailsClass("2", "Chris", "", "offline"));
    }
}