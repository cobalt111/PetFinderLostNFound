package com.timothycox.petfinder_lostnfound.util;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.timothycox.petfinder_lostnfound.exception.CacheNotFoundException;
import com.timothycox.petfinder_lostnfound.model.Animal;

import java.util.Calendar;

import static android.support.constraint.Constraints.TAG;
import static com.timothycox.petfinder_lostnfound.util.DatabaseCache.isCacheInvalid;
import static com.timothycox.petfinder_lostnfound.util.DatabaseCache.readDatabaseFromFile;
import static com.timothycox.petfinder_lostnfound.util.DatabaseCache.updateCache;
import static com.timothycox.petfinder_lostnfound.util.DatabaseCache.verifyCacheFile;

public class DatabaseRequest {

    private static Firebase firebase = Firebase.getInstance();
    private static JsonObject currentDatabase = null;

    // todo figure out how to process images
    public static void submitAnimal(@NonNull Animal animal) {
        animal.setToken(firebase.getFirebaseInstanceToken());
        final DatabaseReference databaseReference = firebase.getDatabaseReference().push();
        animal.setKey(databaseReference.getKey());
        // todo process imageurls
        databaseReference.setValue(animal.parseAnimalToHashMap());
        if (verifyCacheFile()) {
            updateCache();
        }
    }

    public static Animal getAnimal(@NonNull final String animalID) {
        // todo test parsing JSON for animal
        try {
            JsonObject database = loadDatabase(false);
            JsonElement animalElement = database.get(animalID);
            return new GsonBuilder().create().fromJson(animalElement, Animal.class);
        } catch (CacheNotFoundException e) {
            Log.d(TAG, "Failed to find cache while getting animal.");
            e.printStackTrace();
        }
        return null;
    }

    // todo test
    public static JsonObject loadDatabase(boolean forceDownload) throws CacheNotFoundException {
        if (!forceDownload) {
            if (verifyCacheFile()) {
                if (isCacheInvalid(Calendar.getInstance())) updateCache();
                return readDatabaseFromFile();
            } else throw new CacheNotFoundException("Failed to find cache when loading database.");
        } else return getDatabaseFromFirebase();
    }

    public static JsonObject getDatabaseFromFirebase() {
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
