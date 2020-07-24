package com.example.shupple_multi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView ,recyclerView_beverages ;
    ArrayList<String> arrayList ,arrayList_bevarages;
    RecyclerView.LayoutManager recyclerLayoutManager;
    list_adapter listAdapter ,list_adapter_bevarage;
    LinearLayoutManager linearLayoutManager,linearLayoutManager_bevarages;

    List<String[]> listCategory;

//    private ListView firstList;
//    private  ListView secondList;

    private String[] bestSellers ={ " Hopping Tails(3 kg) " , " Nutri Organic Rose Water(250ml) ", " Nutriorg Steelcut Oats(10000g) ", " Nutriorg rooled Oats(10000g) "};
    private String[] Bevarges ={ " Nutriorg Noni  Juice(500ml) " , " Nutriorg Jamun Juice(500ml) ", " Nutriorg Apple Juice(500ml) "};
    private String[] second ={ " s4 " , " s5 ", " s6 "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        firstList = (ListView) findViewById(R.id.listview1);
//        secondList = (ListView) findViewById(R.id.listview2);
//
//        firstList.setAdapter(new ArrayAdapter<String>(this,R.layout.list_layout_item,first));
//        secondList.setAdapter(new ArrayAdapter<String>(this,R.layout.list_layout_item,second));

         listCategory= new ArrayList<String[]>();

        recyclerLayoutManager = new LinearLayoutManager((getApplicationContext()));
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(recyclerLayoutManager);

        linearLayoutManager_bevarages =new LinearLayoutManager((getApplicationContext()));
        recyclerView_beverages = (RecyclerView)findViewById(R.id.recycler_view_bevarages);
        recyclerView_beverages.setLayoutManager(linearLayoutManager_bevarages);


        arrayList  = new ArrayList<>();
        arrayList.addAll(Arrays.asList(bestSellers));
        listAdapter = new list_adapter(arrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(listAdapter);

        arrayList_bevarages = new ArrayList<>();
        arrayList_bevarages.addAll(Arrays.asList(Bevarges));
        list_adapter_bevarage = new list_adapter(arrayList_bevarages);

        recyclerView_beverages.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView_beverages.setAdapter(list_adapter_bevarage);


    }
}
