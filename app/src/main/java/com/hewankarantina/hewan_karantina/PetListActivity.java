package com.hewankarantina.hewan_karantina;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.hewankarantina.hewan_karantina.fragment.CatListFragment;
import com.hewankarantina.hewan_karantina.fragment.DogListFragment;

public class PetListActivity extends AppCompatActivity {

    // widget
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);

        // inisialisasi
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        setSupportActionBar(toolbar);
        PetAdapter adapter = new PetAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    class PetAdapter extends FragmentStatePagerAdapter {
        public PetAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = null;
            if (position == 0) {
                f = new CatListFragment();
            }
            if (position == 1) {
                f = new DogListFragment();
            }
            return f;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String name = null;
            if (position == 0) {
                name = "Cat";
            }
            if (position == 1) {
                name = "Dog";
            }
            return name;
        }
    }
}
