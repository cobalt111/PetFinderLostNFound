package com.timothycox.petfinder_lostnfound.util;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.gson.JsonArray;
import com.timothycox.petfinder_lostnfound.model.Animal;

import java.util.HashMap;

public class DatabaseRequest {

    private static Firebase firebase = Firebase.getInstance();

    // todo figure out how to process images
    public static void submitAnimal(HashMap<String, Object> animal) {
        animal.put("token", firebase.getFirebaseInstanceToken());

        final DatabaseReference newAnimalReference = firebase.getDatabaseReference().push();
        final String key = newAnimalReference.getKey();
        animal.put("key", key);

        newAnimalReference.setValue(animal);
    }

//    public static Animal getAnimal(@NonNull final String animalID) {
//        // todo implement usage of cache to retrieve animals
//
//    }

    public static JsonArray downloadDatabase() {
        final JsonArray jsonArray = new JsonArray();
        firebase.access(false, new Firebase.OnGetDataListener() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure(DatabaseError databaseError) {

            }
        });
        return jsonArray;
    }
}
