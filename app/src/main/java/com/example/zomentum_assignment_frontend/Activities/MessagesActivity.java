package com.example.zomentum_assignment_frontend.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zomentum_assignment_frontend.Adapters.MessageRecyclerAdapter;
import com.example.zomentum_assignment_frontend.Classes.ChatClass;
import com.example.zomentum_assignment_frontend.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessagesActivity extends AppCompatActivity {


    ArrayList<ChatClass> mChat = new ArrayList<>();
    RecyclerView recyclerView;

    TextView userName;
    CircleImageView cicleImage;
    Toolbar toolbar;
    Intent intent;
    RecyclerView.LayoutManager layoutManager;
    ImageView send;
    EditText txt_msg;
    TextView seen;
    String userid;
    MessageRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        userName = findViewById(R.id.other_guy_name);
        cicleImage = findViewById(R.id.other_guy_pic);
        recyclerView = findViewById(R.id.chatrecycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        send = findViewById(R.id.btn_send);
        txt_msg = findViewById(R.id.text_send);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MessagesActivity.this, HomeScreen.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = txt_msg.getText().toString();
                mChat.add(new ChatClass("", "", message, false));
                adapter = new MessageRecyclerAdapter(MessagesActivity.this, mChat, "");
                txt_msg.setText("");
                recyclerView.setAdapter(adapter);
            }
        });
    }
}