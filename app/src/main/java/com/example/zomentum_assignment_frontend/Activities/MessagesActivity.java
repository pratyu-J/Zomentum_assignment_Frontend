package com.example.zomentum_assignment_frontend.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zomentum_assignment_frontend.Adapters.MessageRecyclerAdapter;
import com.example.zomentum_assignment_frontend.Classes.ChatClass;
import com.example.zomentum_assignment_frontend.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessagesActivity extends AppCompatActivity {

    MessageRecyclerAdapter messageAdapter;

    ArrayList<ChatClass> mChat;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    TextView userName;
    CircleImageView cicleImage;
    Toolbar toolbar;
    Intent intent;

    ImageView send;
    EditText txt_msg;
    TextView seen;
    String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
    }
}