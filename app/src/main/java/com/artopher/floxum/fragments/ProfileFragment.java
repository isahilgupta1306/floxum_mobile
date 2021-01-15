package com.artopher.floxum.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.artopher.floxum.ExpandableHeightGridVIew;
import com.artopher.floxum.R;
import com.artopher.floxum.newLoginPage;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    ExpandableHeightGridVIew gridView;
    int images[] = {R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image2};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public class CustomAdapter extends BaseAdapter{

        private int imagesPhoto[];
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(int[] imagesPhoto, Context context) {
            this.imagesPhoto = imagesPhoto;
            this.context = context;
            this.layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imagesPhoto.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView==null)
            {
                convertView = layoutInflater.inflate(R.layout.row_items,parent,false);
            }

            ImageView imageView = convertView.findViewById(R.id.imageView);

            imageView.setImageResource(imagesPhoto[position]);

            return convertView;
        }
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View result = inflater.inflate(R.layout.fragment_profile, container, false);
        gridView=result.findViewById(R.id.gridView);
        gridView.setExpanded(true);
        CustomAdapter customAdapter = new CustomAdapter(images,getActivity());

        gridView.setAdapter(customAdapter);

        Button logout = result.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences= getContext().getSharedPreferences("sharedPrefs",0);
                sharedPreferences.edit().clear().commit();
                Intent intent = new Intent(getContext(), newLoginPage.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return result;
    } 
}