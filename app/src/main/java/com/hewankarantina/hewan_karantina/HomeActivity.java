package com.hewankarantina.hewan_karantina;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.hewankarantina.hewan_karantina.fragment.HomeFragment;
import com.hewankarantina.hewan_karantina.fragment.NotificationsFragment;
import com.hewankarantina.hewan_karantina.fragment.ProfileFragment;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // initialize
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        HomeFragment fragment = new HomeFragment();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.fragment_container, fragment, "Home Fragment");
        fragmentTransaction1.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment fragment = new HomeFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment, "Home Fragment");
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_notif:
                    NotificationsFragment fragment1 = new NotificationsFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.fragment_container, fragment1, "Notifications Fragment");
                    fragmentTransaction1.commit();
                    return true;
                case R.id.navigation_profile:
                    ProfileFragment fragment2 = new ProfileFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.fragment_container, fragment2, "Profile Fragment");
                    fragmentTransaction2.commit();
                    return true;
            }
            return false;
        }
    };
}
