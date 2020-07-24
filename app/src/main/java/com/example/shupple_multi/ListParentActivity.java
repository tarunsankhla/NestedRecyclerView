package com.example.shupple_multi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListParentActivity extends RecyclerView.Adapter<ListParentActivity.MyViewHolder> {

    //private List<Movie> moviesList;
    Context context;

    private EventInformation eventInformation;
    private Activity activity;

    public ListParentActivity(EventInformation eventInformation,Activity activity) {
        this.eventInformation = eventInformation;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_parent, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        EventDates eventDates = eventInformation.getEventsDatesList().get(position);
        holder.event_list_parent_date.setText(eventDates.getDate());

//        LinearLayoutManager hs_linearLayout = new LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false);
//        holder.event_recycler_view_child.setLayoutManager(hs_linearLayout);


        holder.event_recycler_view_child.setHasFixedSize(true);
        ListChildActivity eventListChildAdapter = new ListChildActivity(this.activity,eventInformation.getEventsDatesList().get(position).getEventsArrayList());
        holder.event_recycler_view_child.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        holder.event_recycler_view_child.setAdapter(eventListChildAdapter);

    }

    @Override
    public int getItemCount() {
        return eventInformation.getEventsDatesList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView event_list_parent_date;
        public RecyclerView event_recycler_view_child;

        public MyViewHolder(View view) {
            super(view);
            event_list_parent_date = (TextView) view.findViewById(R.id.event_list_parent_text);
            event_recycler_view_child = (RecyclerView)view.findViewById(R.id.recycler_view_parent_view);
        }
    }
}