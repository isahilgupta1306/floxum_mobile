package com.artopher.floxum.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artopher.floxum.R;

import java.util.ArrayList;
import java.util.List;

import adapter.EventAdapter;
import adapter.ModelClassRVevent;


public class EventFragment extends Fragment {

    RecyclerView event_rv;
    List<ModelClassRVevent> eventList ;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        event_rv = view.findViewById(R.id.event_rv);
        event_rv.setHasFixedSize(true);
        event_rv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        //initData();
        event_rv.setAdapter(new EventAdapter(initData3()));

        return view;
    }

    private List<ModelClassRVevent> initData3() {

        eventList= new ArrayList<>();

        eventList.add(new ModelClassRVevent(R.drawable.dace_event_sample ,
                "Queens Dance" , "13/06/2020" , "Loni, Pune" ,R.drawable.ic_location ,R.drawable.ic_calendar));
        eventList.add(new ModelClassRVevent(R.drawable.dace_event_sample ,
                "Queens Dance" , "13/06/2020" , "Loni, Pune" ,R.drawable.ic_location ,R.drawable.ic_calendar));
        eventList.add(new ModelClassRVevent(R.drawable.dace_event_sample ,
                "Queens Dance" , "13/06/2020" , "Loni, Pune" ,R.drawable.ic_location ,R.drawable.ic_calendar));
        eventList.add(new ModelClassRVevent(R.drawable.dace_event_sample ,
                "Queens Dance" , "13/06/2020" , "Loni, Pune" ,R.drawable.ic_location ,R.drawable.ic_calendar));
        eventList.add(new ModelClassRVevent(R.drawable.dace_event_sample ,
                "Queens Dance" , "13/06/2020" , "Loni, Pune" ,R.drawable.ic_location ,R.drawable.ic_calendar));
        eventList.add(new ModelClassRVevent(R.drawable.dace_event_sample ,
                "Queens Dance" , "13/06/2020" , "Loni, Pune" ,R.drawable.ic_location ,R.drawable.ic_calendar));
        eventList.add(new ModelClassRVevent(R.drawable.dace_event_sample ,
                "Queens Dance" , "13/06/2020" , "Loni, Pune" ,R.drawable.ic_location ,R.drawable.ic_calendar));
        eventList.add(new ModelClassRVevent(R.drawable.dace_event_sample ,
                "Queens Dance" , "13/06/2020" , "Loni, Pune" ,R.drawable.ic_location ,R.drawable.ic_calendar));
        eventList.add(new ModelClassRVevent(R.drawable.dace_event_sample ,
                "Queens Dance" , "13/06/2020" , "Loni, Pune" ,R.drawable.ic_location ,R.drawable.ic_calendar));
        eventList.add(new ModelClassRVevent(R.drawable.dace_event_sample ,
                "Queens Dance" , "13/06/2020" , "Loni, Pune" ,R.drawable.ic_location ,R.drawable.ic_calendar));



        return eventList;

    }
}