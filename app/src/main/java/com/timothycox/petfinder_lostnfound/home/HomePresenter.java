package com.timothycox.petfinder_lostnfound.home;

import android.content.Context;
import android.content.Intent;

import com.timothycox.petfinder_lostnfound.BasePresenter;
import com.timothycox.petfinder_lostnfound.post.PostActivity;

class HomePresenter extends BasePresenter {

    private HomeView homeView;

    HomePresenter(HomeView homeView) {
        this.homeView = homeView;
    }

    void onPost(Context context) {
        Intent intent = new Intent(context, PostActivity.class);
        context.startActivity(intent);
    }
}
