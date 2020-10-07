package com.example.trialsecond;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public String tsubj;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference ref=db.getReference();
    private Button btn1;
    TextView[] [] tv=new TextView[3][3];
    TextView tohrval;
    String hello;
    List<Integer> sublst=new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tohrval=findViewById(R.id.tohrval);

        tv[0][0]=findViewById(R.id.r1c1);
        tv[0][1]=findViewById(R.id.r1c2);
        tv[0][2]=findViewById(R.id.r1c3);
        tv[1][0]=findViewById(R.id.r2c1);
        tv[1][1]=findViewById(R.id.r2c2);
        tv[1][2]=findViewById(R.id.r2c3);
        tv[2][0]=findViewById(R.id.r3c1);
        tv[2][1]=findViewById(R.id.r3c2);
        tv[2][2]=findViewById(R.id.r3c3);
        Intent i=getIntent();
        hello=i.getStringExtra("hi");

        Toast.makeText(MainActivity.this, hello, Toast.LENGTH_LONG).show();



        /*ref.child("TotalData").child("Hr").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                tsubj=snapshot.getValue().toString();
                tohrval.setText(tsubj);

                for (int q = 0; q < Integer.parseInt(tsubj); q++) {
                    for (int o = 0; o < 3; o++) {
                        ref.child("TotalSubj").child(String.valueOf(q + 1)).child(String.valueOf(o+1)).child("Subject").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                String chi = snapshot.getValue(String.class);

                                Toast.makeText(MainActivity.this, chi,Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }

            }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        /*if(tsubj!=null) {
            for (int q = 0; q < Integer.parseInt(tsubj); q++) {
                for (int o = 0; o < 3; o++) {
                   ref.child("TotalSubj").child(String.valueOf(q + 1)).child(String.valueOf(o+1)).child("Subject").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            hello = snapshot.getValue().toString();
                            int j=0;
                        *//*if(i!=null){
                            j=Integer.parseInt(i);
                        }*//*
                        Toast.makeText(MainActivity.this, hello,Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }

            }
        }*/

        /*for(int q=0; q<Integer.parseInt(tsubj); q++){

        }

        for(int q=0; q<Integer.parseInt(tsubj); q++){

        }*/

        btn1= (Button) findViewById(R.id.new_schedule);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(),TotalData.class);
                startActivity(intent1);

            }
        });
    }

}