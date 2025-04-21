package com.example.itubeapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PlaylistDao {
    @Query("SELECT * FROM playlist")
    List<PlaylistEntry> getAll();

    @Insert
    void insert(PlaylistEntry e);
}
