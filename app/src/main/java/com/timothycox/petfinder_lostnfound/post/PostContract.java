package com.timothycox.petfinder_lostnfound.post;

import com.timothycox.petfinder_lostnfound.BasePresenter;
import com.timothycox.petfinder_lostnfound.model.Animal;

interface PostContract {
    interface View {
        void populateDataFields(final Animal animal);

        void onClickButton(android.view.View view);

        void onSubmitButtonClickEvent(final Animal animal);

        void onAddPictureClickEvent();

        Animal buildAnimalFromEnteredData();
    }

    interface Presenter extends BasePresenter {
        void createEditInstance(final Animal animal);

        void onClickSubmit(final Animal animal);

        void onClickAddPicture();
    }
}
