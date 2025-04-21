package com.example.itubeapp;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class VideoFragment extends Fragment {
    private static final String ARG_URL = "url";

    public static VideoFragment newInstance(String url) {
        VideoFragment f = new VideoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_URL, url);
        f.setArguments(args);
        return f;
    }

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_video, container, false);
        YouTubePlayerView playerView = v.findViewById(R.id.youtube_player_view);

        // tie the playerView to this fragment's lifecycle
        getLifecycle().addObserver(playerView);

        playerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String url = getArguments() != null ? getArguments().getString(ARG_URL) : null;
                if (url != null) {
                    // extract the “v” param from a youtube URL like https://www.youtube.com/watch?v=VIDEO_ID
                    Uri uri = Uri.parse(url);
                    String videoId = uri.getQueryParameter("v");
                    if (videoId == null) {
                        // maybe they passed an “youtu.be/…” short link
                        videoId = uri.getLastPathSegment();
                    }
                    if (videoId != null) {
                        youTubePlayer.loadVideo(videoId, 0f);
                    }
                }
            }
        });

        return v;
    }
}
