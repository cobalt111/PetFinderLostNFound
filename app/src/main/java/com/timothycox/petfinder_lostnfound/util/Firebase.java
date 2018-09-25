package com.timothycox.petfinder_lostnfound.util;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;

class Firebase {

    private static final Firebase ourInstance = new Firebase();
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String firebaseInstanceToken;

    private Firebase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        firebaseInstanceToken = FirebaseInstanceId.getInstance().getToken();
    }

    public static Firebase getInstance() {
        return ourInstance;
    }

    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }

    public String getFirebaseInstanceToken() {
        return firebaseInstanceToken;
    }

    public void access(boolean continuousUpdating,
                       final Firebase.OnGetDataListener listener) {
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
