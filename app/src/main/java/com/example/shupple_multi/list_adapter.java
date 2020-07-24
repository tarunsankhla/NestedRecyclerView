package com.example.shupple_multi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class list_adapter extends RecyclerView.Adapter<list_adapter.MyView> {
    private List<String> list;
    public class MyView extends RecyclerView.ViewHolder {
        TextView text_view;
        public MyView(@NonNull View itemView) {
            super(itemView);
            text_view = (TextView)itemView.findViewById(R.id.text);
        }
    }

    public list_adapter(List<String> horizontalList){
        this.list = horizontalList;
    }
    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout_item,parent,false);
        return new MyView(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.text_view.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
