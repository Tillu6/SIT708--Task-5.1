package com.example.itubeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * Binds a list of PlaylistEntry objects to a RecyclerView.
 * When the play button is tapped, we invoke the provided Consumer<String> with the URL.
 */
public class PlaylistAdapter
        extends RecyclerView.Adapter<PlaylistAdapter.VH> {

    private final List<PlaylistEntry> list;
    private final java.util.function.Consumer<String> play;

    public PlaylistAdapter(List<PlaylistEntry> list,
                           java.util.function.Consumer<String> play) {
        this.list = list;
        this.play = play;
    }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_playlist, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        String url = list.get(position).getUrl();
        holder.txtUrl.setText(url);
        holder.btnPlay.setOnClickListener(x -> play.accept(url));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /** Simple ViewHolder with a TextView and a Button. */
    static class VH extends RecyclerView.ViewHolder {
        final TextView txtUrl;
        final Button btnPlay;

        VH(View itemView) {
            super(itemView);
            txtUrl  = itemView.findViewById(R.id.txt_url);
            btnPlay = itemView.findViewById(R.id.btn_play);
        }
    }
}
