package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RelatedNewsAdapter
        extends RecyclerView.Adapter<RelatedNewsAdapter.RelatedVH> {

    private final List<Article> list;
    private final TopStoriesAdapter.OnClickListener listener;

    public RelatedNewsAdapter(List<Article> data, TopStoriesAdapter.OnClickListener l) {
        list = data;
        listener = l;
    }

    @NonNull
    @Override
    public RelatedVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_related_news, parent, false);
        return new RelatedVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RelatedVH holder, int position) {
        Article a = list.get(position);
        // TODO: load a.getImageUrl() into holder.imgRelated
        holder.txtRelated.setText(a.getTitle());
        holder.itemView.setOnClickListener(v -> listener.onClick(a));
    }

    @Override public int getItemCount() { return list.size(); }

    static class RelatedVH extends RecyclerView.ViewHolder {
        ImageView imgRelated;
        TextView txtRelated;
        RelatedVH(View itemView) {
            super(itemView);
            imgRelated = itemView.findViewById(R.id.img_related);
            txtRelated = itemView.findViewById(R.id.txt_related);
        }
    }
}