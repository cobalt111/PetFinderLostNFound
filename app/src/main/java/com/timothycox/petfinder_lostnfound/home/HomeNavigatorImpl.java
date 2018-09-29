package com.timothycox.petfinder_lostnfound.home;

import android.content.Context;
import android.content.Intent;

import com.timothycox.petfinder_lostnfound.post.PostActivity;

class HomeNavigatorImpl implements HomeFragment.HomeNavigator {

    private Context context;

    public HomeNavigatorImpl(Context context) {
        this.context = context;
    }

    @Override
    public void onPost() {
        context.startActivity(new Intent(context, PostActivity.class));
    }
}
