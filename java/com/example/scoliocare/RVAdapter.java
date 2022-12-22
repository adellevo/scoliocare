package com.example.scoliocare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    ArrayList<Event> list = new ArrayList<>();

    public RVAdapter(Context ctx) {
        this.context = ctx;
    }

    public void setItems(ArrayList<Event> event) {
        list.addAll(event);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new EventVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EventVH vh = (EventVH) holder;
        Event event = list.get(position);
        vh.txt_name.setText(event.getName());
        vh.txt_date.setText(event.getDate());
        vh.txt_time.setText(event.getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
