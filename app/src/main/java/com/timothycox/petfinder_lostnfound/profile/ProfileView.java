package com.timothycox.petfinder_lostnfound.profile;

import com.timothycox.petfinder_lostnfound.BaseView;
import com.timothycox.petfinder_lostnfound.model.Animal;

interface ProfileView extends BaseView {
    void populateDataFields(Animal animal);

    void onClickEdit();

    void onClickStatusChange();
}
