package com.example.dbtr;
import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase db;
    private DatabaseReference ref;
    private List<Book> data= new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Book> ad, List<String> keys);

    }

    public FirebaseDatabaseHelper() {
        db=FirebaseDatabase.getInstance();
        ref=db.getReference("books").child("4");
    }
    int i=1;
    public void readData(final DataStatus ds){
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                data.clear();
                List<String> keys=new ArrayList<>();
                for(DataSnapshot keyNode: snapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Book ad= keyNode.getValue(Book.class);
                    data.add(ad);
                }
                ds.DataIsLoaded(data,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
