package com.timothycox.petfinder_lostnfound.home;

import com.timothycox.petfinder_lostnfound.BasePresenterImpl;

class HomePresenterImpl extends BasePresenterImpl implements HomeContract.Presenter {

    private HomeContract.View homeView;

    public HomePresenterImpl(HomeContract.View homeView) {
        this.homeView = homeView;
    }

    @Override
    public void onPost() {
        homeView.navigateToPost();
    }
}
