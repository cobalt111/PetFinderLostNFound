package com.timothycox.petfinder_lostnfound.home;

interface HomeContract {
    interface View {
        void onClickPost();

        void navigateToPost();
    }

    interface Presenter {
        void onPost();
    }
}
