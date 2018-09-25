package com.timothycox.petfinder_lostnfound.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.timothycox.petfinder_lostnfound.exception.DataNotReturnedException;
import com.timothycox.petfinder_lostnfound.model.Animal;

import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Calendar;

import static android.support.constraint.Constraints.TAG;

public class DatabaseCache {

    private static final int UPDATE_INTERVAL_HOURS = 6;
    private static final String CACHE_FILENAME = "lnf-cache.json";
    private static File cache;
    private static Calendar lastModifiedTimestamp;

    // todo is passing context instead of passing file correct?
    public static void setCache(@NonNull Context context) {
        cache = new File(context.getCacheDir(), CACHE_FILENAME);
    }

    // todo verify calendar operates properly
    public static void updateCache(boolean forceUpdate) {
        if (!validCache(Calendar.getInstance()) || forceUpdate) {
            writeDatabaseToFile();
            updateLastModifiedTimestamp();
        }
    }

    public static boolean validCache(@NonNull Calendar currentTime) {
        return currentTime.get(Calendar.HOUR) < lastModifiedTimestamp.get(Calendar.HOUR) + UPDATE_INTERVAL_HOURS;
    }

    // todo figure out how to read from file properly
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


    private static void updateLastModifiedTimestamp() {
        lastModifiedTimestamp = Calendar.getInstance();
    }
}
