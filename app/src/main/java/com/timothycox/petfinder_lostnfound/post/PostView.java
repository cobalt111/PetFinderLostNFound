package com.timothycox.petfinder_lostnfound.post;

import com.timothycox.petfinder_lostnfound.BaseView;

import java.util.HashMap;

interface PostView extends BaseView {
    void onClickSubmit();

    void populateDataFields(HashMap<String, Object> currentAnimal);

    void onClickAddPicture();
}
