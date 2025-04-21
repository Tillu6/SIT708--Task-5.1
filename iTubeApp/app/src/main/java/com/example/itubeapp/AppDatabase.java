package com.example.itubeapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// Tell Room about your entity and version
@Database(entities = { PlaylistEntry.class }, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    // Expose your DAO
    public abstract PlaylistDao playlistDao();
}
