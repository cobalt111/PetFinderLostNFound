package com.timothycox.petfinder_lostnfound.post;

import com.timothycox.petfinder_lostnfound.BaseView;
import com.timothycox.petfinder_lostnfound.model.Animal;

interface PostView extends BaseView {
    void onClickSubmit();

    void populateDataFields(Animal animal);

    void onClickAddPicture();
}
