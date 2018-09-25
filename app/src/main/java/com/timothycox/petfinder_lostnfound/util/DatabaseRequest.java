package com.timothycox.petfinder_lostnfound.util;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.timothycox.petfinder_lostnfound.exception.DataNotReturnedException;
import com.timothycox.petfinder_lostnfound.model.Animal;

import java.util.Calendar;
import java.util.HashMap;

import static android.support.constraint.Constraints.TAG;

public class DatabaseRequest {

    private static Firebase firebase = Firebase.getInstance();
    private static JsonObject currentDatabase;

    // todo figure out how to process images
    public static void submitAnimal(@NonNull HashMap<String, Object> animal) {
        animal.put("token", firebase.getFirebaseInstanceToken());
        final DatabaseReference newAnimalReference = firebase.getDatabaseReference().push();
        final String key = newAnimalReference.getKey();
        animal.put("key", key);
        newAnimalReference.setValue(animal);
        if (DatabaseCache.verifyCacheFile()) {
            DatabaseCache.updateCache(true);
        }
    }

//    public static Animal getAnimal(@NonNull final String animalID) {
//        // todo implement usage of cache to retrieve animals
//    }

    // todo test if this works
    static JsonObject loadDatabase(boolean forceDownload) {
        if (DatabaseCache.validCache(Calendar.getInstance()) && !forceDownload) {
            if (DatabaseCache.verifyCacheFile())
                return DatabaseCache.readDatabaseFromFile();
            else {
                DatabaseCache.updateCache(true);
                return DatabaseCache.readDatabaseFromFile();
            }
        } else return getDatabaseFromFirebase();
    }

    private static JsonObject getDatabaseFromFirebase() {
        firebase.access(false, new Firebase.OnGetDataListener() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                currentDatabase = dataSnapshot.getValue(JsonObject.class);
            }
            @Override
            public void onStart() {

            }

            @Override
            public void onFailure(DatabaseError databaseError) {
                Log.d(TAG, databaseError.getDetails());
            }
        });
        return currentDatabase;
    }
}
