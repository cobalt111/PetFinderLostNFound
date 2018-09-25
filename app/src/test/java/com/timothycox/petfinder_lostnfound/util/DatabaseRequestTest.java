package com.timothycox.petfinder_lostnfound.util;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.gson.JsonObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DatabaseRequestTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void submitAnimal() {
    }

    @Test
    public void getAnimal() {
    }

    @Test
    public void loadDatabase() {


    }

    @Test
    public void getDatabaseFromFirebase() {
        Firebase firebase = Firebase.getInstance();

        firebase.access(false, new Firebase.OnGetDataListener() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                JsonObject jsonObject = dataSnapshot.getValue(JsonObject.class);
                assertNotNull(jsonObject);
            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure(DatabaseError databaseError) {

            }
        });

    }
}