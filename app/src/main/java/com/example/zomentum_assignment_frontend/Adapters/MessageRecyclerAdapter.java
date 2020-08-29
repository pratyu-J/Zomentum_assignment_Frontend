package com.example.zomentum_assignment_frontend.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zomentum_assignment_frontend.Classes.ChatClass;
import com.example.zomentum_assignment_frontend.R;

import java.util.ArrayList;

public class MessageRecyclerAdapter extends RecyclerView.Adapter<MessageRecyclerAdapter.ViewHolder> {

    private static final int MESSAGE_TYPE_LEFT = 0;
    private static final int MESSAGE_TYPE_RIGHT = 1;

    private Context mContext;
    private ArrayList<ChatClass> mChat;
    private String imgUrl;


    public MessageRecyclerAdapter(Context mContext, ArrayList<ChatClass> mChat, String imgUrl){
        this.mContext = mContext;
        this.mChat = mChat;
        this.imgUrl = imgUrl;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == MESSAGE_TYPE_RIGHT){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.right_chat, parent, false);
            return new MessageRecyclerAdapter.ViewHolder(v);
        }else{
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.left_chat, parent, false);
            return new MessageRecyclerAdapter.ViewHolder(v);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final ChatClass curr = mChat.get(position);

        holder.show_message.setText(curr.getMessage());

        if(imgUrl.equals("default")){
            holder.img.setImageResource(R.drawable.person_vector);
        }
        else {
            Glide.with(mContext).load(imgUrl).into(holder.img);
        }

            holder.txt_seen.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return mChat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView show_message;
        TextView txt_seen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            show_message = itemView.findViewById(R.id.show_message);
            img = itemView.findViewById(R.id.prof_img);
            txt_seen = itemView.findViewById(R.id.seen);

        }
    }


}
