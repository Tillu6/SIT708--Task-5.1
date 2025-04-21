package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.transition.MaterialFadeThrough;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {
    private RecyclerView rvTopStories, rvNews;
    private List<Article> articles = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // smooth fade‑through when navigating forward
        setExitTransition(new MaterialFadeThrough());

        // TODO: Replace with real data fetch
        articles.add(new Article(
                "Sample Headline",
                "This is a sample description for the news item.",
                "https://via.placeholder.com/400",
                new ArrayList<>()
        ));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        rvTopStories = view.findViewById(R.id.rv_top_stories);
        rvNews       = view.findViewById(R.id.rv_news);

        rvTopStories.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvNews.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        rvTopStories.setAdapter(new TopStoriesAdapter(articles, this::openDetail));
        rvNews.setAdapter(new NewsAdapter(articles, this::openDetail));

        return view;
    }

    private void openDetail(Article article) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, NewsDetailFragment.newInstance(article))
                .addToBackStack(null)
                .commit();
    }
}
