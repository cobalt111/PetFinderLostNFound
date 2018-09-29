package com.timothycox.petfinder_lostnfound.profile;

import com.timothycox.petfinder_lostnfound.model.Animal;

interface ProfileContract {
    interface View {
        void populateDataFields(final Animal animal);

        void onClickButton(android.view.View view);

        void onEditClickEvent(final Animal animal);

        void onStatusChangeClickEvent(final Animal animal);
    }

    interface Presenter {
        void createProfile();

        void onEditButton();

        void onStatusChangeButton();

        void notifyOwnerOfStatusChange();
    }
}
