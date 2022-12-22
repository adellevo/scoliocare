package com.example.scoliocare;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalTime;

public class EventEditActivity extends AppCompatActivity {
    private EditText event_name;
    private TextView event_date, event_time;
    private Button save_button;
    private String date, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();

        event_date.setText("Date: " + date);
        event_time.setText("Time: " + time);
    }

    private void initWidgets() {
        event_name = findViewById(R.id.eventNameET);
        event_date = findViewById(R.id.eventDateTV);
        event_time = findViewById(R.id.eventTimeTV);
        save_button = findViewById(R.id.save_btn);
        date = CalendarUtils.formattedDate(CalendarUtils.selectedDate);
        time = CalendarUtils.formattedTime(LocalTime.now());
    }

    public void saveEventAction(View v) {
//        DAOEvent dao = new DAOEvent();
        Event newEvent = new Event(event_name.getText().toString(), date, time);

        WeekViewActivity.dao.add(newEvent).addOnSuccessListener(suc -> {
            Toast.makeText(this, "Record's inserted", Toast.LENGTH_SHORT).show();
//            Event.eventsList.add(newEvent);
            finish();
        }).addOnFailureListener(er -> {
            Toast.makeText(this, er.getMessage(), Toast.LENGTH_SHORT).show();
        });
    }
}