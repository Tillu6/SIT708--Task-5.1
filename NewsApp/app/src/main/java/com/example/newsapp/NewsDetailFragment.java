package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.transition.MaterialFadeThrough;

import java.util.List;

public class NewsDetailFragment extends Fragment {
    private static final String ARG_ARTICLE = "arg_article";
    private Article article;

    public static NewsDetailFragment newInstance(Article art) {
        NewsDetailFragment frag = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ARTICLE, art);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // smooth fade‑through on entry and return
        setEnterTransition(new MaterialFadeThrough());
        setReturnTransition(new MaterialFadeThrough());

        if (getArguments() != null && getArguments().containsKey(ARG_ARTICLE)) {
            article = getArguments().getParcelable(ARG_ARTICLE);
        } else {
            throw new IllegalStateException(
                    "NewsDetailFragment must be instantiated via newInstance(article)");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);

        ImageView imgDetail    = view.findViewById(R.id.img_detail);
        TextView  txtDetail    = view.findViewById(R.id.txt_detail);
        RecyclerView rvRelated = view.findViewById(R.id.rv_related);

        // TODO: load image into imgDetail (e.g. with Glide or Picasso)
        // Glide.with(this).load(article.getImageUrl()).into(imgDetail);

        txtDetail.setText(article.getDescription());

        List<Article> related = article.getRelatedArticles();
        rvRelated.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvRelated.setAdapter(new RelatedNewsAdapter(related, this::openRelated));

        return view;
    }

    private void openRelated(Article art) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, NewsDetailFragment.newInstance(art))
                .addToBackStack(null)
                .commit();
    }
}
