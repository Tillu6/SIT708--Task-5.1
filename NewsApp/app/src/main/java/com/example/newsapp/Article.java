package com.example.newsapp;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class Article implements Parcelable {
    private String title;
    private String description;
    private String imageUrl;
    private List<Article> relatedArticles;

    protected Article(Parcel in) {
        title = in.readString();
        description = in.readString();
        imageUrl = in.readString();
        relatedArticles = in.createTypedArrayList(Article.CREATOR);
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }
        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public Article(String t, String d, String url, List<Article> rel) {
        title = t; description = d; imageUrl = url; relatedArticles = rel;
    }

    @Override public int describeContents() { return 0; }
    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(imageUrl);
        dest.writeTypedList(relatedArticles);
    }

    // Getters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; }
    public List<Article> getRelatedArticles() { return relatedArticles; }
}