package com.timothycox.petfinder_lostnfound.profile;

import android.content.Context;
import android.content.Intent;

import com.timothycox.petfinder_lostnfound.BasePresenter;
import com.timothycox.petfinder_lostnfound.post.PostActivity;

import java.util.HashMap;

class ProfilePresenter extends BasePresenter {

    private ProfileView profileView;
    private String animalID;

    ProfilePresenter(ProfileView profileView, final String animalID) {
        this.profileView = profileView;
        this.animalID = animalID;
    }

    void createProfile() {
        HashMap<String, Object> animal = new HashMap<>();
        // todo receive data from db

        profileView.populateDataFields(animal);
    }

    void onEdit(Context context) {
        Intent intent = new Intent(context, PostActivity.class);
        intent.putExtra("animalID", animalID);
        intent.putExtra("isEditInstance", true);
        context.startActivity(intent);
    }

    void onStatusChange() {

    }

    private void notifyOwnerOfFoundStatusChange() {

    }
}
