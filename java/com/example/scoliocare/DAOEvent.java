package com.example.scoliocare;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class DAOEvent {
    private DatabaseReference databaseReference;

    public DAOEvent() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Event.class.getSimpleName());
    }

    public Task<Void> add(Event event) {
        return databaseReference.push().setValue(event);
    }

    public Task<Void> update(String key, HashMap<String, Object> hashMap) {
        return databaseReference.child(key).updateChildren(hashMap);
    }

    public Task<Void> remove(String key) {
        return databaseReference.child(key).removeValue();
    }

    public Query get() {
        return databaseReference.orderByChild("date").equalTo(CalendarUtils.formattedDate(CalendarUtils.selectedDate));
    }
}
