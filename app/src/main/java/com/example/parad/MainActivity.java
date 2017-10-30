package com.example.parad;

        import android.content.Intent;
        import android.support.annotation.NonNull;
        import android.support.design.widget.BottomNavigationView;
        import android.support.design.widget.TabLayout;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v4.view.ViewPager;
        import android.os.Bundle;
        import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_filter:
                    return true;

                case R.id.navigation_plus:
                    return true;

                case R.id.navigation_person:
                    intent = new Intent(MainActivity.this, UserProfileActivity.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new tab1Start(), "Start");
        adapter.addFragment(new tab2Play(), "Play");
        adapter.addFragment(new tab3Top(), "Top");
        viewPager.setAdapter(adapter);
    }


}
