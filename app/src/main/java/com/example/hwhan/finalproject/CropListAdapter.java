package com.example.hwhan.finalproject;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


public class CropListAdapter extends RecyclerView.Adapter<CropListAdapter.ViewHolder> {

    public  List<CropData> CropList;


    public CropListAdapter(List<CropData> cropdata){
        CropList = cropdata;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cropcard, viewGroup, false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        CropData list = CropList.get(i);
        viewHolder.name.setText(list.getName());
        viewHolder.price.setText(list.getPrice());
        viewHolder.level.setText(list.getLevel());
    }


    @Override
    public int getItemCount() {
        return 3;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
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

