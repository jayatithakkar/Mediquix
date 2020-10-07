package com.example.trialsecond;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class Done extends AppCompatActivity {
    String tjsub,tjsab;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference ref=db.getReference();
    TextView tv;
    int q=0, o=0;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

        Intent i=getIntent();
        tjsub=i.getStringExtra("ji");
        tjsab=i.getStringExtra("pi");
        tv=findViewById(R.id.shw);
        tv.setText(tjsab);

        rv=(RecyclerView) findViewById(R.id.recyclerview_books);
        new FirebaseDatabaseHelper(tjsub).readData(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<ActualData> ad, List<String> keys) {
                new RecyclerView_Config().setConfig(rv, Done.this, ad,keys);
            }
        });

        /*ref.child("TotalSubj").child(tjsub).child(tjsub).child("Algo").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String hiu=snapshot.getValue().toString();
                tv[0][0].setText(hiu);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/



    }
}