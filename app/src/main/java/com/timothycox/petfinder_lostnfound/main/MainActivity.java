package com.timothycox.petfinder_lostnfound.main;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.timothycox.petfinder_lostnfound.R;
import com.timothycox.petfinder_lostnfound.home.HomeFragment;
import com.timothycox.petfinder_lostnfound.listings.ListingsFragment;
import com.timothycox.petfinder_lostnfound.listings.dummy.DummyContent;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,
        ListingsFragment.OnListFragmentInteractionListener {

    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    // region BottomNavigationView
    // todo add proper buttons and actions for bottomnavview
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        // todo change to use home, listings, yourpets
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle(R.string.title_home);
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_listings:
                    setTitle(R.string.title_listings);
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_yourpets:
                    setTitle(R.string.title_yourpets);
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };
    // endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        DatabaseCache.setCache(getApplicationContext().getCacheDir());
//        if (DatabaseCache.verifiedCacheFile())
//            DatabaseCache.updateCache();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onBackPressed() {
        int currentItem = viewPager.getCurrentItem();
        if (currentItem == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(currentItem - 1);
        }
    }
}
