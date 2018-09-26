package com.timothycox.petfinder_lostnfound.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.timothycox.petfinder_lostnfound.exception.CacheNotFoundException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import static android.support.constraint.Constraints.TAG;

public class DatabaseCache {

    private static final int UPDATE_INTERVAL_HOURS = 2;
    private static final String CACHE_FILENAME = "lnf-cache.json";
    private static File cache;
    private static Calendar lastModifiedTimestamp = Calendar.getInstance();

    // todo is passing context instead of passing file correct?
    public static void setCache(@NonNull Context context) {
        cache = new File(context.getCacheDir(), CACHE_FILENAME);
    }

    // todo test
    public static void updateCache() {
        if (isCacheInvalid(Calendar.getInstance())) {
            writeDatabaseToFile();
            updateLastModifiedTimestamp();
        }
    }

    // todo test
    public static boolean isCacheInvalid(@NonNull Calendar currentTime) {
        int updateExpirationTime = lastModifiedTimestamp.get(Calendar.HOUR_OF_DAY) + UPDATE_INTERVAL_HOURS;
        return currentTime.get(Calendar.HOUR_OF_DAY) > updateExpirationTime;
    }

    // todo test
    public static void writeDatabaseToFile() {
        verifyCacheFile();
        try {
            JsonObject jsonObject = DatabaseRequest.loadDatabase(true);
            FileWriter writer = new FileWriter(cache);
            writer.write(jsonObject.toString());
        } catch (IOException e) {
            Log.d(TAG, "Error writing JSON to cache.");
            e.printStackTrace();
        } catch (CacheNotFoundException e) {
            Log.d(TAG, "Failed to write database to file, cache not found.");
            e.printStackTrace();
        }
    }


    public static JsonObject readDatabaseFromFile() {
        try {
            FileReader reader = new FileReader(cache);
            return new JsonParser().parse(reader).getAsJsonObject();
        } catch (IOException e) {
            Log.d(TAG, "Error reading JSON from cache.");
            e.printStackTrace();
        }
        return null;
    }

    public static boolean verifyCacheFile() {
        if (!cache.exists()) {
            try {
                return cache.createNewFile();
            } catch (IOException e) {
                Log.d(TAG, "Error creating cache file.");
                e.printStackTrace();
                return false;
            }
        } else return true;
    }

    public static void updateLastModifiedTimestamp() {
        lastModifiedTimestamp = Calendar.getInstance();
    }
}
