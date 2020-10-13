package com.artopher.floxum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {
    TabLayout tabLayout;
    FloatingActionButton fb , google;
    ConstraintLayout constraintLayout;
    ViewPager viewPager;
    ImageView rectangle , logo ;
    float v=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Hooks
        tabLayout =(TabLayout)findViewById(R.id.tabLayout);
        fb =(FloatingActionButton)findViewById(R.id.fb_button);
        google =(FloatingActionButton)findViewById(R.id.google_button);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        logo=(ImageView)findViewById(R.id.logo);
        rectangle=(ImageView)findViewById(R.id.rectangle_green);
        constraintLayout = (ConstraintLayout)findViewById(R.id.constraintLayout);

        //TabLayout columns

        tabLayout.addTab(tabLayout.newTab().setText("Login"));
        tabLayout.addTab(tabLayout.newTab().setText("SignUp"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Creating object of loginAdapter
        final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(),this,tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //Animations
        tabLayout.setTranslationY(300);
        fb.setTranslationY(300);
        google.setTranslationY(300);

        fb.setAlpha(v);
        google.setAlpha(v);
        tabLayout.setAlpha(v);

        fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();


    }
}