package com.timothycox.petfinder_lostnfound.profile;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.timothycox.petfinder_lostnfound.BasePresenter;
import com.timothycox.petfinder_lostnfound.model.Animal;
import com.timothycox.petfinder_lostnfound.post.PostActivity;
import com.timothycox.petfinder_lostnfound.util.DatabaseRequest;

class ProfilePresenter extends BasePresenter {

    private ProfileView profileView;
    private String animalID;

    ProfilePresenter(@NonNull ProfileView profileView, @NonNull final String animalID) {
        this.profileView = profileView;
        this.animalID = animalID;
    }

    void createProfile() {
        Animal animal = DatabaseRequest.getAnimal(animalID);
        profileView.populateDataFields(animal);
    }

    void onEdit(@NonNull Context context) {
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
