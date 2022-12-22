package com.example.scoliocare;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Event {
    public static ArrayList<Event> eventsList = new ArrayList<>();

    public static ArrayList<Event> eventsForDate(LocalDate date) {
        String dateString = CalendarUtils.formattedDate(date);

        List<Event> targetEvents = eventsList
                .stream()
                .filter(event -> event.getDate().equals(dateString))
                .collect(Collectors.toList());

        return (ArrayList<Event>) targetEvents;

//        ArrayList<Event> events = new ArrayList<>();
//
//        for (Event event : eventsList) {
//            if (event.getDate().equals(CalendarUtils.formattedDate(date)))
//                events.add(event);
//        }
//
//        return events;
    }

    private String name;
    private String date;
    private String time;
    private String deleted;

    public Event() {
    }

    public Event(String name, String date, String time, String deleted) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.deleted = deleted;
    }

    public Event(String name, String date, String time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", deleted='" + deleted + '\'' +
                '}';
    }
}
