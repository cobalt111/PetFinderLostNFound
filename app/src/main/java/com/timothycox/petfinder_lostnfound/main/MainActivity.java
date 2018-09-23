package com.timothycox.petfinder_lostnfound.main;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.timothycox.petfinder_lostnfound.R;
import com.timothycox.petfinder_lostnfound.home.HomeFragment;
import com.timothycox.petfinder_lostnfound.listings.ListingsFragment;
import com.timothycox.petfinder_lostnfound.listings.dummy.DummyContent;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, ListingsFragment.OnListFragmentInteractionListener {

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    // region bottomnavview
    // todo add proper buttons and actions for bottomnavview
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle(R.string.title_home);
                    return true;
                case R.id.navigation_listings:
                    setTitle(R.string.title_listings);
                    return true;
                case R.id.navigation_yourpets:
                    setTitle(R.string.title_yourpets);
                    return true;
                case R.id.navigation_map:
                    setTitle(R.string.title_map);
                    return true;
            }
            return false;
        }
    };
    // endregion

    // region Activity Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // region Set up viewpager
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2) {
                    // todo when yourpets is selected but empty, display toast saying so
                }
            }
//            int previousState;
            @Override
            public void onPageScrollStateChanged(int state) {
//                if (previousState == ViewPager.SCROLL_STATE_DRAGGING && state == ViewPager.SCROLL_STATE_SETTLING) {
//                    //user scroll
//                }
//
//                else if (previousState == ViewPager.SCROLL_STATE_SETTLING && state == ViewPager.SCROLL_STATE_IDLE) {
//                    //programmatic scroll
//                }
//
//                previousState = state;
            }
        });
        // endregion

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    // endregion

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
