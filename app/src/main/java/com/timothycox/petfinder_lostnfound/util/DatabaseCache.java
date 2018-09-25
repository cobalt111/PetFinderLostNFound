package com.timothycox.petfinder_lostnfound.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import static android.support.constraint.Constraints.TAG;

public class DatabaseCache {

    private static final long UPDATE_INTERVAL_HOURS = 2;
    private static final String CACHE_FILENAME = "lnf-cache.json";
    private static File cache;
    private static Date lastModifiedTimestamp = Calendar.getInstance().getTime();

    // todo is passing context instead of passing file correct?
    public static void setCache(@NonNull Context context) {
        cache = new File(context.getCacheDir(), CACHE_FILENAME);
    }

    // todo use something other than calendar
    public static void updateCache(boolean forceUpdate) {
        if (!validCache(Calendar.getInstance().getTime()) || forceUpdate) {
            writeDatabaseToFile();
            updateLastModifiedTimestamp();
        }
    }

    // todo fix this, doesn't capture time properly
    static boolean validCache(@NonNull Date currentTime) {
        return currentTime.getTime() < lastModifiedTimestamp.getTime() + UPDATE_INTERVAL_HOURS;
    }

    private static void writeDatabaseToFile() {
        JsonObject jsonObject = DatabaseRequest.loadDatabase(true);
        try {
            FileWriter writer = new FileWriter(cache);
            writer.write(jsonObject.toString());
        } catch (IOException e) {
            Log.d(TAG, "Error writing JSON to cache.");
            e.printStackTrace();
        }
    }

    // todo figure out how to read from file properly
    static JsonObject readDatabaseFromFile() {
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

    private static void updateLastModifiedTimestamp() {
        lastModifiedTimestamp = Calendar.getInstance().getTime();
    }
}
