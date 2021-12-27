package com.example.gitapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder>  {
    private List<PostPojo> dataList;
    private Context context;
    private List<PostPojo> dataListAll;
    public Adapter(Context context,List<PostPojo> dataList){
        this.context=context;
        this.dataList=dataList;
        this.dataListAll = new ArrayList<>(dataList);
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_recyclerview,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
            holder.titles.setText(dataList.get(position).getLogin());
            holder.posts.setText(dataList.get(position).getUrl());
            Picasso.get().load(dataList.get(position).getAvatar_url()).placeholder(R.drawable.loading).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    static class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView titles , posts;
        ImageView imageView;
        CustomViewHolder(View view){
            super(view);
            titles= itemView.findViewById(R.id.title);
            posts = itemView.findViewById(R.id.githubLink);
            imageView=itemView.findViewById(R.id.cover);

        }
    }
}
