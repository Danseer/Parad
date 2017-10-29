package com.example.parad;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

private  Intent intent;
    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_filter:

                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    tab1Start catFragment = new tab1Start();
                    ft.replace(R.id.container, catFragment);
                    ft.commit();
                    return true;

                case R.id.navigation_plus:

                    intent = new Intent(MainActivity.this,AddActivity.class);
                    startActivity(intent);
                    return true;

                case R.id.navigation_person:

                   // intent = new Intent(MainActivity.this, LoginActivity.class);
                   // startActivity(intent);

                    return true;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    tab1Start tab1 = new tab1Start();
                    return tab1;
                case 1:
                    tab2Play tab2 = new tab2Play();
                    return tab2;
                case 2:
                    tab3Top tab3 = new tab3Top();
                    return tab3;
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.tab1Name);
                case 1:
                    return getResources().getString(R.string.tab2Name);
                case 2:
                    return getResources().getString(R.string.tab3Name);
            }
            return null;
        }
    }
}
