package com.example.scoliocare;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RVActivity extends AppCompatActivity {
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    RVAdapter adapter;
    DAOEvent dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        swipeRefreshLayout = findViewById(R.id.swipe);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new RVAdapter(this);
        recyclerView.setAdapter(adapter);

        dao = new DAOEvent();
        loadData();
    }

    private void loadData() {
        dao.get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Event> events = new ArrayList<>();
                for (DataSnapshot data : snapshot.getChildren()) {
                    Event event = data.getValue(Event.class);
                    events.add(event);
                }
                adapter.setItems(events);
                adapter.notifyDataSetChanged(); // items in recycler view are aware of change
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}