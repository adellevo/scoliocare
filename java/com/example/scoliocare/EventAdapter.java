package com.example.scoliocare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EventAdapter extends ArrayAdapter<Event> {
//    ArrayList<Event> displayedEvents;

    public EventAdapter(@NonNull Context context, ArrayList<Event> events) {
        super(context, 0, events);
//        super(context, 0);
//        displayedEvents = events;
//        setEvents(displayedEvents);
    }

//    public EventAdapter(@NonNull Context context) {
//        super(context, 0);
//    }

//    public void setEvents(ArrayList<Event> events) {
//        ArrayList<Event> filteredEvents = new ArrayList<>();
//        for (Event event : events) {
//            if (event.getDate().equals(CalendarUtils.formattedDate(CalendarUtils.selectedDate))) {
//                filteredEvents.add(event);
//            }
//        }
//        displayedEvents = filteredEvents;
//    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Event event = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_cell, parent, false);

        TextView eventCellTV = convertView.findViewById(R.id.eventCellTV);
        String eventTitle = event.getName() + ", " + event.getDate();
        eventCellTV.setText(eventTitle);
        return convertView;
    }

}
