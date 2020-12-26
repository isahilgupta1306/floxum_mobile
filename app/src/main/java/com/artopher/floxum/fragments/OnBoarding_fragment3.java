package com.artopher.floxum.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.artopher.floxum.R;
import com.artopher.floxum.newLoginPage;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class OnBoarding_fragment3 extends Fragment {
    FloatingActionButton fab;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



            ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_on_boarding3 , container , false);
            fab=root.findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), newLoginPage.class);
                    startActivity(intent);
                }
            });
            return root;
        }



}
