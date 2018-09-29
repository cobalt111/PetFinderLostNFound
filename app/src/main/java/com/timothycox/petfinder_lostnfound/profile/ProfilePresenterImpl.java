package com.timothycox.petfinder_lostnfound.profile;

import android.support.annotation.NonNull;

import com.timothycox.petfinder_lostnfound.BasePresenterImpl;
import com.timothycox.petfinder_lostnfound.model.Animal;
import com.timothycox.petfinder_lostnfound.model.util.DatabaseProvider;

class ProfilePresenterImpl extends BasePresenterImpl implements ProfileContract.Presenter {

    private ProfileContract.View profileView;
    private Animal animal;

    public ProfilePresenterImpl(@NonNull ProfileContract.View profileView, @NonNull final Animal animal) {
        this.profileView = profileView;
        this.animal = animal;
    }

    @Override
    public void createProfile() {
        profileView.populateDataFields(animal);
    }

    @Override
    public void onEditButton() {
        profileView.onEditClickEvent(animal);
    }

    @Override
    public void onStatusChangeButton() {
        if (animal.getStatus().equals("lost")) animal.setStatus("found");
        else if (animal.getStatus().equals("found")) animal.setStatus("lost");
        notifyOwnerOfStatusChange();
        profileView.onStatusChangeClickEvent(animal);
    }

    @Override
    public void notifyOwnerOfStatusChange() {
        DatabaseProvider.changeAnimalStatusInDB(animal);
    }
}
