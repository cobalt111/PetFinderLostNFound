package com.timothycox.petfinder_lostnfound.model.util;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.timothycox.petfinder_lostnfound.model.Animal;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class DatabaseProvider {

    private static Firebase firebase = Firebase.getInstance();
    private static DataSnapshot currentDatabase = null;

    // todo figure out how to process images
    public static void submitAnimal(@NonNull Animal animal) {
        animal.setToken(firebase.getFirebaseInstanceToken());
        DatabaseReference newAnimalReference = firebase.getDatabaseReference()
                .child("server")
                .child("animals")
                .push();
        animal.setKey(newAnimalReference.getKey());
        // todo process imageurls
        newAnimalReference.setValue(animal.parseAnimalToHashMap());

//        if (verifiedCacheFile()) {
//            updateCache();
//        }
    }

    public static List<Animal> getAnimals() {
        Query query = firebase.getDatabaseReference()
                .child("server")
                .child("animals")
                .orderByChild("date");
        firebase.access(false, query, new Firebase.OnGetDataListener() {
            @Override
            public void onSuccessfulAdd(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onSuccessfulChange(DataSnapshot dataSnapshot) {
                currentDatabase = dataSnapshot;
            }

            @Override
            public void onSuccessfulRemoval(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onSuccessfulMove(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onFailure(DatabaseError databaseError) {
                Log.d(TAG, databaseError.getDetails());
            }
        });
        return parseDataSnapshotAsList(currentDatabase);

        //        // todo test parsing JSON for animal
//        try {
//            return new GsonBuilder()
//                    .create()
//                    .fromJson(loadDatabase(false).get(animalID), Animal.class);
//        } catch (CacheNotFoundException e) {
//            Log.d(TAG, "Failed to find cache while getting animal.");
//            e.printStackTrace();
//        }
//        // todo return null?
//        return null;
    }

    public static void changeAnimalStatusInDB(@NonNull final Animal animal) {
        DatabaseReference statusChangeRef = firebase.getDatabaseReference()
                .child("server")
                .child("animals")
                .child(animal.getKey())
                .child("status");
        statusChangeRef.setValue(animal.getStatus());
    }

    private static List<Animal> parseDataSnapshotAsList(DataSnapshot dataSnapshot) {
        List<Animal> animals = new ArrayList<>();
        Iterable<DataSnapshot> databaseAnimals = dataSnapshot.getChildren();
        for (DataSnapshot animalEntry : databaseAnimals) {
            animals.add(animalEntry.getValue(Animal.class));
        }
        return animals;
    }

    // todo test
//    public static DataSnapshot loadDatabase(boolean forceDownload) {
//        if (!forceDownload) {
//            if (verifiedCacheFile()) {
//                if (isCacheInvalid(Calendar.getInstance())) updateCache();
//                return readDatabaseFromFile();
//            } else throw new CacheNotFoundException("Failed to find cache when loading database.");
//        } else return getDatabaseFromFirebase();
//    }

//    public static void getDatabaseFromFirebase() {
//        firebase.access(false, firebase.getDatabaseReference(), new Firebase.OnGetDataListener() {
//            @Override
//            public void onSuccess(DataSnapshot dataSnapshot) {
//                currentDatabase = dataSnapshot;
//            }
//
//            @Override
//            public void onFailure(DatabaseError databaseError) {
//                Log.d(TAG, databaseError.getDetails());
//            }
//        });
//    }


}
