package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.artopher.floxum.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    List<ModelClassRVevent> eventList1;

    public EventAdapter(List<ModelClassRVevent> eventList) {
        this.eventList1 = eventList;
    }

    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_rv_template,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.event_image.setImageResource(eventList1.get(position).getEvent_image());
        holder.event_title.setText(eventList1.get(position).getEvent_title());
        holder.event_location.setText(eventList1.get(position).getEvent_location());
        holder.event_date.setText(eventList1.get(position).getEvent_date());
        holder.location_icon.setImageResource(eventList1.get(position).getLocation_pin());
        holder.calendar_icon.setImageResource(eventList1.get(position).getCalendar_icon());

        //Cardview onClick funtion :
        holder.event_cardview_rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }

    @Override
    public int getItemCount() {
        return eventList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView event_image , location_icon , calendar_icon;
        MaterialTextView event_title , event_date , event_location;
        MaterialCardView event_cardview_rv ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            event_image = itemView.findViewById(R.id.event_image);
            location_icon = itemView.findViewById(R.id.locationPin);
            calendar_icon = itemView.findViewById(R.id.calendar_icon);
            event_date = itemView.findViewById(R.id.event_date);
            event_location = itemView.findViewById(R.id.event_location);
            event_title = itemView.findViewById(R.id.event_title1);
            event_cardview_rv = itemView.findViewById(R.id.event_rv_card);
        }
    }
}
