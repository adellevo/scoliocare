package com.example.scoliocare;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventVH extends RecyclerView.ViewHolder {
    public TextView txt_name, txt_date, txt_time;

    public EventVH(@NonNull View itemView) {
        super(itemView);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_date = itemView.findViewById(R.id.txt_date);
        txt_time = itemView.findViewById(R.id.txt_time);
    }
}
