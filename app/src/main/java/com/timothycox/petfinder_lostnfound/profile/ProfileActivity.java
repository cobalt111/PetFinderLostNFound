package com.timothycox.petfinder_lostnfound.profile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.timothycox.petfinder_lostnfound.R;

public class ProfileActivity extends AppCompatActivity implements ProfileView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}
