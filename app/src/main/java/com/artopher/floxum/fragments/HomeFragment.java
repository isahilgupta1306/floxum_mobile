package com.artopher.floxum.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artopher.floxum.ModelClass;
import com.artopher.floxum.R;
import com.artopher.floxum.topEventsAdapter;

import java.util.ArrayList;
import java.util.List;

import adapter.ModelClassRVpost;
import adapter.PostAdapter;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView , user_postRV ;
    List<ModelClass> itemList;
    List<ModelClassRVpost> postList;





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

        // Inflate the layout for this fragment
        //View view2 =  inflater.inflate(R.layout.fragment_home, container, false);
        user_postRV = view.findViewById(R.id.user_post_templateRV);
        user_postRV.setHasFixedSize(true);
        user_postRV.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        //initData2();
        user_postRV.setAdapter(new PostAdapter(initData2()));





        return view ;

    }

    private List<ModelClassRVpost> initData2() {
        postList= new ArrayList<>();
        postList.add(new ModelClassRVpost(R.drawable.dummy_post, R.drawable.fuckerberg ,
                "9 Nov , Mon" ,"@username" , "Name" , "trying to be cool"));
        postList.add(new ModelClassRVpost(R.drawable.dummy_post, R.drawable.fuckerberg ,
                "9 Nov , Mon" ,"@username" , "Name" , "trying to be cool"));
        postList.add(new ModelClassRVpost(R.drawable.dummy_post, R.drawable.fuckerberg ,
                "9 Nov , Mon" ,"@username" , "Name" , "trying to be cool"));
        postList.add(new ModelClassRVpost(R.drawable.dummy_post, R.drawable.fuckerberg ,
                "9 Nov , Mon" ,"@username" , "Name" , "trying to be cool"));
        postList.add(new ModelClassRVpost(R.drawable.dummy_post, R.drawable.fuckerberg ,
                "9 Nov , Mon" ,"@username" , "Name" , "trying to be cool"));

        return postList;

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