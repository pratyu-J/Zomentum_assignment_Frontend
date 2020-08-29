package com.example.zomentum_assignment_frontend.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zomentum_assignment_frontend.Adapters.FriendsRecyclerAdapter;
import com.example.zomentum_assignment_frontend.Classes.FriendDetailsClass;
import com.example.zomentum_assignment_frontend.R;

import java.util.ArrayList;


public class ChatsFragment extends Fragment {

    RecyclerView recyclerView;
    FriendsRecyclerAdapter recyclerAdapter;
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

        recyclerAdapter = new FriendsRecyclerAdapter(getContext(),list , true);
        return v;
    }
}