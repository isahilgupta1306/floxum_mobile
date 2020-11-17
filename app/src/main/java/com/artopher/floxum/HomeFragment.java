package com.artopher.floxum;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    List<ModelClass> itemList;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recycler_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        //initData();
        recyclerView.setAdapter(new topEventsAdapter(initData()));

        return view;

    }

    private List<ModelClass> initData() {
        itemList= new ArrayList<>();
        itemList.add(new ModelClass(R.drawable.dummy_image, "Photography"));
        itemList.add(new ModelClass(R.drawable.dummy_image, "Photography"));
        itemList.add(new ModelClass(R.drawable.dummy_image, "Photography"));
        itemList.add(new ModelClass(R.drawable.dummy_image, "Photography"));
        itemList.add(new ModelClass(R.drawable.dummy_image, "Photography"));
        itemList.add(new ModelClass(R.drawable.dummy_image, "Photography"));
        itemList.add(new ModelClass(R.drawable.dummy_image, "Photography"));
        itemList.add(new ModelClass(R.drawable.dummy_image, "Photography"));

        return itemList;

    }


}