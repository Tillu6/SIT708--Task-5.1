package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TopStoriesAdapter
        extends RecyclerView.Adapter<TopStoriesAdapter.TopVH> {

    private final List<Article> list;
    private final OnClickListener listener;

    public interface OnClickListener { void onClick(Article article); }

    public TopStoriesAdapter(List<Article> data, OnClickListener l) {
        list = data;
        listener = l;
    }

    @NonNull
    @Override
    public TopVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_top_story, parent, false);
        return new TopVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TopVH holder, int position) {
        Article a = list.get(position);
        // TODO: load a.getImageUrl() into holder.imgTop
        holder.txtTop.setText(a.getTitle());
        holder.itemView.setOnClickListener(v -> listener.onClick(a));
    }

    @Override public int getItemCount() { return list.size(); }

    static class TopVH extends RecyclerView.ViewHolder {
        ImageView imgTop;
        TextView txtTop;
        TopVH(View itemView) {
            super(itemView);
            imgTop = itemView.findViewById(R.id.img_top);
            txtTop = itemView.findViewById(R.id.txt_top);
        }
    }
}