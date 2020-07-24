package com.example.shupple_multi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView event_recycler_view_parent;
    ListParentActivity event_list_parent_adapter;

    String jsonString = "{\n" +
            "\"Id\" : \"1\",\n" +
            "\"Name\" : \"Ganesha\",\n" +
            "\"Location\" : \"Bengaluru\",\n" +
            "\"Category info\" : [ \n" +
                "{\n" +
                    "\"CategoryName\" : \"Best Sellers\",\n" +
                    "\"categoryElements\" : [ \n" +
                        "{\n" +
                            "\"productId\" : \"1\",\n" +
                            "\"productName\" : \"Hopping Tails(3 kg)\"\n" +
                        "}, \n" +
                        "{\n" +
                            "\"productId\" : \"2\",\n" +
                            "\"productName\" : \"Nutri Organic Rose Water(250ml)\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"productId\" : \"3\",\n" +
                        "\"productName\" : \"Nutriorg Steelcut Oats(10000g)\"\n" +
                        "} ,\n" +
                        "{\n" +
                        "\"productId\" : \"8\",\n" +
                        "\"productName\" : \"Nutriorg rooled Oats(10000g)\"\n" +
                        "} \n" +


                    "]\n" +
                "}, \n" +
            "{\n" +
                "\"CategoryName\" : \"Beverages\",\n" +
                "\"categoryElements\" : [ \n" + "{\n" +
                        "\"productId\" : \"4\",\n" +
                        "\"productName\" : \"Nutriorg Noni  Juice(500ml)\"\n" +
                        "}, \n" +
                        "{\n" +
                        "\"productId\" : \"5\",\n" +
                        "\"productName\" : \"Nutriorg Jamun Juice(500ml)\"\n" +
                        "} ,\n" +
                        "{\n" +
                        "\"productId\" : \"6\",\n" +
                        "\"productName\" : \"Nutriorg Apple Juice(500ml)\"\n" +
                        "} \n" +

                    "]\n" +
                    "}\n" +
                "]\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ArrayList<EventDates> eventDatesArrayList;
        EventInformation eventInformation = new EventInformation();


        try {
            //pasing jason data
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonDatesArray = jsonObject.getJSONArray("Category info");
            eventDatesArrayList = new ArrayList<>();
            for (int indexDates=0;indexDates<jsonDatesArray.length();indexDates++){
                EventDates eventDates = new EventDates();
                JSONObject jsonDateobject = jsonDatesArray.getJSONObject(indexDates);
                String date = jsonDateobject.getString("CategoryName");
                eventDates.setDate(date);
                JSONArray jsonArrayevents = jsonDateobject.getJSONArray("categoryElements");
                ArrayList<Events> eventsArrayList = new ArrayList<>();
                for (int indexEvents=0;indexEvents<jsonArrayevents.length();indexEvents++){
                    Events events = new Events();
                    JSONObject eventObj = jsonArrayevents.getJSONObject(indexEvents);
                    events.setEventId(eventObj.getString("productId"));
                    events.setEventName(eventObj.getString("productName"));
                    eventsArrayList.add(events);
                    Log.d("message", String.valueOf(eventsArrayList));
                }
                eventDates.setEventsArrayList(eventsArrayList);
                eventDatesArrayList.add(eventDates);
            }
            eventInformation.setEventsDatesList(eventDatesArrayList);
            Log.d("message",eventInformation.toString());
        }catch (Exception e){

        }
        //parent recyclerview
        event_recycler_view_parent = (RecyclerView) findViewById(R.id.recycler_view_parent);
        event_list_parent_adapter = new ListParentActivity(eventInformation,MainActivity2.this);
        event_recycler_view_parent.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        event_recycler_view_parent.setLayoutManager(mLayoutManager);
        event_recycler_view_parent.setItemAnimator(new DefaultItemAnimator());
        event_recycler_view_parent.setAdapter(event_list_parent_adapter);


    }


}