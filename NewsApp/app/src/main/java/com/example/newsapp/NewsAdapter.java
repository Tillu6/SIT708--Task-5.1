package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NewsAdapter
        extends RecyclerView.Adapter<NewsAdapter.NewsVH> {

    private final List<Article> list;
    private final TopStoriesAdapter.OnClickListener listener;

    public NewsAdapter(List<Article> data, TopStoriesAdapter.OnClickListener l) {
        list = data;
        listener = l;
    }

    @NonNull
    @Override
    public NewsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        return new NewsVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsVH holder, int position) {
        Article a = list.get(position);
        // TODO: load a.getImageUrl() into holder.imgNews
        holder.txtNews.setText(a.getTitle());
        holder.itemView.setOnClickListener(v -> listener.onClick(a));
    }

    @Override public int getItemCount() { return list.size(); }

    static class NewsVH extends RecyclerView.ViewHolder {
        ImageView imgNews;
        TextView txtNews;
        NewsVH(View itemView) {
            super(itemView);
            imgNews = itemView.findViewById(R.id.img_news);
            txtNews = itemView.findViewById(R.id.txt_news);
        }
    }
}