package com.timothycox.petfinder_lostnfound.post;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.timothycox.petfinder_lostnfound.R;

public class PostActivity extends AppCompatActivity implements PostView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
    }
}
