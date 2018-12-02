package com.example.hwhan.finalproject;

import android.database.CrossProcessCursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class CropListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public  List<CropData> clist;

    public CropListAdapter(List<CropData> cropdata){
        clist = cropdata;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cropcard, viewGroup, false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
       CropData list = clist.get(i);
        viewHolder.name.setText(list.getName());
        viewHolder.price.setText(list.getPrice());
        viewHolder.level.setText(list.getLevel());

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView price;
        TextView level;
        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            price = view.findViewById(R.id.price);
            level = view.findViewById(R.id.level);
        }
    }
}

