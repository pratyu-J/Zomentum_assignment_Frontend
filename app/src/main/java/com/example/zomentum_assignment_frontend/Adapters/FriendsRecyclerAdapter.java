package com.example.zomentum_assignment_frontend.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zomentum_assignment_frontend.Activities.MessagesActivity;
import com.example.zomentum_assignment_frontend.Classes.FriendDetailsClass;
import com.example.zomentum_assignment_frontend.R;

import java.util.ArrayList;
import java.util.List;

public class FriendsRecyclerAdapter extends RecyclerView.Adapter<FriendsRecyclerAdapter.ViewHolder> implements Filterable {

    private Context mContext;
    private ArrayList<FriendDetailsClass> friends;
    private ArrayList<FriendDetailsClass> friendsListFull;
    private boolean isChat;

    public FriendsRecyclerAdapter(Context mContext, ArrayList<FriendDetailsClass> friends, boolean isChat) {
        this.mContext = mContext;
        this.friends = friends;
        friendsListFull = new ArrayList<>(friends);
        this.isChat = isChat;
    }

    public FriendsRecyclerAdapter(){

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.friends_recycler_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final FriendDetailsClass friendDetailsClass = friends.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MessagesActivity.class);
                intent.putExtra("username", friendDetailsClass.getUsername());
                mContext.startActivity(intent);
            }
        });

        holder.username.setText(friendDetailsClass.getUsername());

        if(isChat){
            holder.lastMsg.setVisibility(View.VISIBLE);
            //holder.lastMsg.setText("hello");
            holder.username.setText(friendDetailsClass.getUsername());

        }
        else {
            holder.lastMsg.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView username;
        ImageView img_off;
        TextView lastMsg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.profile_pic);
            username = itemView.findViewById(R.id.user_name);
            img_off = itemView.findViewById(R.id.img_off);
            lastMsg = itemView.findViewById(R.id.last_message);
        }
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<FriendDetailsClass> filteredList = new ArrayList<>();

            if(charSequence==null || charSequence.length()==0){
                filteredList.addAll(friendsListFull);
            }
            else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for(FriendDetailsClass item: friendsListFull){
                    if(item.getUsername().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            friends.clear();
            friends.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };


}
