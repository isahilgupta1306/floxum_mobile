package com.artopher.floxum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DefaultPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_page);

        BottomNavigationView nav = findViewById(R.id.bottom_nav);
        nav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer,new HomeFragment()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener(){


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch(item.getItemId())
            {
                case R.id.home:
                    selectedFragment=new HomeFragment();
                    break;
                case R.id.Group:
                    selectedFragment=new ExploreFragment();
                    break;
                case R.id.event:
                    selectedFragment=new EventFragment();
                    break;
                case R.id.profile:
                    selectedFragment=new ProfileFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer,selectedFragment).commit();
            return true;
        }
    };
    }
