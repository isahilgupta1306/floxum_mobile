package com.artopher.floxum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class IntroductoryActivity extends AppCompatActivity {
    ImageView logo,banner;
    LottieAnimationView lottieAnimationView;
    Animation anim;

    private static final int NUM_PAGES=3;
    private ViewPager viewPager;
    private ScreenSlidePagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);
        //Hooks
        logo =(ImageView) findViewById(R.id.logo);
        banner=(ImageView) findViewById(R.id.banner);
        lottieAnimationView=(LottieAnimationView) findViewById(R.id.lottie);

        //Pager Hooks
        viewPager = (ViewPager)findViewById(R.id.liquidPager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);



        //Animations

        anim = AnimationUtils.loadAnimation(this,R.anim.on_boarding_anim);
        banner.animate().translationY(-2700).setDuration(800).setStartDelay(3000);
        logo.animate().translationY(1400).setDuration(1000).setStartDelay(3000);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(3000);


    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{


        public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    OnBoarding_fragment1 tab1= new OnBoarding_fragment1();

                    return tab1;
                case 1:
                    OnBoarding_fragment2 tab2= new OnBoarding_fragment2();

                    return tab2;
                case 2:
                    OnBoarding_fragment3 tab3= new OnBoarding_fragment3();

                    return tab3;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}