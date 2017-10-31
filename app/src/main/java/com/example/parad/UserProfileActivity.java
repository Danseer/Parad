package com.example.parad;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UserProfileActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        viewPager = (ViewPager) findViewById(R.id.container_profile);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs_profile);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new tab3Top(), "Мои конкурсы");
        adapter.addFragment(new tab3Top(), "Принял участие");
        adapter.addFragment(new tab3Top(), "Проголосовал");
        viewPager.setAdapter(adapter);
    }
}
