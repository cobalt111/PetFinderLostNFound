package com.timothycox.petfinder_lostnfound.profile;

import com.timothycox.petfinder_lostnfound.BaseView;

import java.util.HashMap;

interface ProfileView extends BaseView {
    void populateDataFields(HashMap<String, Object> animal);

    void onClickEdit();

    void onClickStatusChange();
}
