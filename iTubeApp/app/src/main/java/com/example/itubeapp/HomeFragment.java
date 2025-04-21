package com.example.itubeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;                          // ← add this

import com.google.android.material.transition.MaterialFadeThrough;

import java.util.List;

public class HomeFragment extends Fragment {
    private EditText edtUrl;
    private Button btnAdd;
    private RecyclerView rvPlaylist;
    private AppDatabase db;
    private PlaylistAdapter adapter;
    private List<PlaylistEntry> list;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnterTransition(new MaterialFadeThrough());
        setExitTransition(new MaterialFadeThrough());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        edtUrl     = v.findViewById(R.id.edt_url);
        btnAdd     = v.findViewById(R.id.btn_add);
        rvPlaylist = v.findViewById(R.id.rv_playlist);

        // initialize Room database
        db = Room.databaseBuilder(
                        requireContext(),
                        AppDatabase.class,
                        "itube-db"
                )
                .allowMainThreadQueries()
                .build();

        // load existing playlist entries
        list = db.playlistDao().getAll();

        // set up RecyclerView
        rvPlaylist.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PlaylistAdapter(list, this::playVideo);
        rvPlaylist.setAdapter(adapter);

        // handle Add button
        btnAdd.setOnClickListener(x -> {
            String url = edtUrl.getText().toString().trim();
            if (!url.isEmpty()) {
                PlaylistEntry entry = new PlaylistEntry(url);
                db.playlistDao().insert(entry);
                list.add(entry);
                adapter.notifyItemInserted(list.size() - 1);
            }
        });

        return v;
    }

    private void playVideo(String url) {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, VideoFragment.newInstance(url))
                .addToBackStack(null)
                .commit();
    }
}
