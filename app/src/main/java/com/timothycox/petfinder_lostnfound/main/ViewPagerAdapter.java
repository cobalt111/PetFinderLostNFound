package com.timothycox.petfinder_lostnfound.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.timothycox.petfinder_lostnfound.home.HomeFragment;
import com.timothycox.petfinder_lostnfound.listings.ListingsFragment;
import com.timothycox.petfinder_lostnfound.listings.yourpets.YourPetsFragment;

import java.util.ArrayList;
import java.util.List;

class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();

    ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentList.add(HomeFragment.newInstance());
        fragmentList.add(ListingsFragment.newInstance());
        fragmentList.add(YourPetsFragment.newInstance());
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
