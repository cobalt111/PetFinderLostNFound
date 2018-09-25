package com.timothycox.petfinder_lostnfound.util;

import android.support.annotation.NonNull;

import com.google.gson.JsonArray;

import java.io.File;
import java.util.Calendar;

public class DatabaseCache {

    private static final DatabaseCache databaseCache = new DatabaseCache();
    private static final int UPDATE_HOUR_INTERVAL = 6;
    private static File cacheDirectory;
    private static Calendar lastModifiedTime;

    private DatabaseCache() {
        updateCache();
    }

    public static DatabaseCache getInstance() {
        return databaseCache;
    }

    public static void updateCache() {
//        JsonArray jsonArray = DatabaseRequest.downloadDatabase();

        // todo write db to cache dir

        updateLastModifiedTime();
    }

//    public static JsonArray loadEntryFromCache(@NonNull final String animalID) {
//        // todo learn how to search JSON for data and return it
//        return
//    }

    public static void setCacheDirectory(@NonNull File directory) {
        cacheDirectory = directory;
    }

    public static boolean validCache(@NonNull Calendar currentTime) {
        return currentTime.get(Calendar.HOUR) < lastModifiedTime.get(Calendar.HOUR) + UPDATE_HOUR_INTERVAL;
    }

    private static void updateLastModifiedTime() {
        lastModifiedTime = Calendar.getInstance();
    }
}
