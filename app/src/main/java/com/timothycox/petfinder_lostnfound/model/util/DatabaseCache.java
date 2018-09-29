//package com.timothycox.petfinder_lostnfound.model.util;
//
//import android.support.annotation.NonNull;
//import android.util.Log;
//
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.timothycox.petfinder_lostnfound.exception.CacheNotFoundException;
//
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Calendar;
//
//import static android.support.constraint.Constraints.TAG;
//
//public class DatabaseCache {
//
//    private static final int EXPIRY_INTERVAL_IN_HOURS = 2;
//    private static final String CACHE_FILENAME = "lnf-cache.json";
//    private static File cache;
//    private static Calendar lastModifiedTimestamp = Calendar.getInstance();
//
//    public static void setCache(File cacheDirectory) {
//        cache = new File(cacheDirectory, CACHE_FILENAME);
//    }
//
//    // todo test
//    public static void updateCache() {
//        try {
//            writeDatabaseToFile();
//        }
//        catch (CacheNotFoundException e) {
//            Log.d(TAG, "Could not find cache file.");
//            e.printStackTrace();
//        }
//        updateLastModifiedTimestamp();
//    }
//
//    // todo test
//    public static boolean isCacheInvalid(@NonNull Calendar currentTime) {
//        int updateExpirationTime = lastModifiedTimestamp.get(Calendar.HOUR_OF_DAY) + EXPIRY_INTERVAL_IN_HOURS;
//        return currentTime.get(Calendar.HOUR_OF_DAY) > updateExpirationTime;
//    }
//
//    // todo is deleting and creating the proper way to do this?
//    public static void writeDatabaseToFile() throws CacheNotFoundException {
//        if (verifiedCacheFile()) {
//            try {
//                cache.delete();
//                cache.createNewFile();
//                JsonObject jsonObject = DatabaseProvider.loadDatabase(true);
//                FileWriter writer = new FileWriter(cache);
//                writer.write(jsonObject.toString());
//                Log.d(TAG, jsonObject.toString());
//            }
//            catch (IOException e) {
//                Log.d(TAG, "Error writing database to cache.");
//                e.printStackTrace();
//            }
//            catch (NullPointerException e) {
//                Log.d(TAG, "JsonObject was null.");
//                e.printStackTrace();
//            }
//        }
//        else throw new CacheNotFoundException();
//    }
//
//
//    public static JsonObject readDatabaseFromFile() {
//        try {
//            FileReader reader = new FileReader(cache);
//            return new JsonParser().parse(reader).getAsJsonObject();
//        } catch (IOException e) {
//            Log.d(TAG, "Error reading JSON from cache.");
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static boolean verifiedCacheFile() {
//        if (!cache.exists()) {
//            try {
//                return cache.createNewFile();
//            } catch (IOException e) {
//                Log.d(TAG, "Error creating cache file.");
//                e.printStackTrace();
//                return false;
//            }
//        } else return true;
//    }
//
//    public static void updateLastModifiedTimestamp() {
//        lastModifiedTimestamp = Calendar.getInstance();
//    }
//}
