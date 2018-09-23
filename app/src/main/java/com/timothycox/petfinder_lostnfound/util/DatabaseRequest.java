package com.timothycox.petfinder_lostnfound.util;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class DatabaseRequest {

    private static Database database = Database.getInstance();

    // todo figure out how to process images
    public static void submitAnimal(HashMap<String, Object> animal) {
        animal.put("token", FirebaseUtil.generateFirebaseInstanceToken());

        final DatabaseReference newAnimalReference = database.getDatabaseReference().push();
        final String key = newAnimalReference.getKey();
        animal.put("key", key);

        newAnimalReference.setValue(animal);
    }

    public static void loadAnimals(DatabaseReference databaseReference, boolean continuousUpdating,
                                   final OnGetDataListener listener) {
        listener.onStart();
        if (continuousUpdating) {
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    listener.onSuccess(dataSnapshot);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    listener.onFailure(databaseError);
                }
            });
        } else {
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    listener.onSuccess(dataSnapshot);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    listener.onFailure(databaseError);
                }
            });
        }
    }

    public interface OnGetDataListener {
        void onSuccess(DataSnapshot dataSnapshot);

        void onStart();

        void onFailure(DatabaseError databaseError);
    }

}
