package com.artopher.floxum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DefaultPage extends AppCompatActivity {

     Animation rotateClockwise;
     Animation rotateAnticlockwise;
     Animation fabOpen;
     Animation fabClose;

     FloatingActionButton fab;
     FloatingActionButton image;
     FloatingActionButton video;
     Boolean Clicked = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_page);

        BottomNavigationView nav = findViewById(R.id.bottom_nav);
        nav.setOnNavigationItemSelectedListener(navListener);

         rotateClockwise = AnimationUtils.loadAnimation(this,R.anim.rotate_clockwise);
         rotateAnticlockwise = AnimationUtils.loadAnimation(this,R.anim.rotate_anticlockwise);
         fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_open);
         fabClose = AnimationUtils.loadAnimation(this,R.anim.fab_close);

        final FloatingActionButton fab = findViewById(R.id.fab);
        final FloatingActionButton image = findViewById(R.id.image);
        final FloatingActionButton video = findViewById(R.id.video);

        getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer,new HomeFragment()).commit();

        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(!Clicked)
                {
                    image.setVisibility(View.VISIBLE);
                    video.setVisibility(View.VISIBLE);
                    image.startAnimation(fabOpen);
                    video.startAnimation(fabOpen);
                    fab.startAnimation(rotateAnticlockwise);
                    image.setClickable(true);
                    video.setClickable(true);
                    Clicked=true;
                }
                else
                {
                    image.setVisibility(View.INVISIBLE);
                    video.setVisibility(View.VISIBLE);
                    image.startAnimation(fabClose);
                    video.startAnimation(fabClose);
                    fab.startAnimation(rotateClockwise);
                    image.setClickable(false);
                    video.setClickable(true);
                    Clicked=false;
                }
            }
        });


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
