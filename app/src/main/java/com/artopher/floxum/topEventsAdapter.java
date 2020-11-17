package com.artopher.floxum;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class topEventsAdapter extends RecyclerView.Adapter<topEventsAdapter.ViewHolder> {
    List<ModelClass> itemList1;

    public topEventsAdapter(List<ModelClass> itemList) {
        this.itemList1=itemList;
    }

    @NonNull
    @Override
    public topEventsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_recyclerview,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull topEventsAdapter.ViewHolder holder, int position) {
        holder.eventImage.setImageResource(itemList1.get(position).getImage());
        holder.title.setText(itemList1.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return itemList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView eventImage;
        MaterialTextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eventImage = itemView.findViewById(R.id.eventImage);
           title = itemView.findViewById(R.id.event_title);


        }
    }
}
