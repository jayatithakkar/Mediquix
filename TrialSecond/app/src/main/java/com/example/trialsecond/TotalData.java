package com.example.trialsecond;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TotalData extends AppCompatActivity {
    private Button btn2;
    private EditText totalhr;
    private EditText totalsubj;
    private DatabaseReference mDatabase;
    String thr,tsub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_data);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        totalsubj= (EditText) findViewById(R.id.totalsub);
        totalhr=(EditText) findViewById(R.id.totalhrs);



        btn2= (Button) findViewById(R.id.add_data_further);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tsub=totalsubj.getText().toString();
                thr=totalhr.getText().toString();
                Intent intent1=new Intent(getApplicationContext(),FinalData.class);
                intent1.putExtra("hi",tsub);
                intent1.putExtra("hello",thr);
                startActivity(intent1);
                writeNewUser(thr,tsub);
            }
        });

    }

    private void writeNewUser(String thr, String tsub) {
        ChildTotalData ad= new ChildTotalData(thr,tsub);
        mDatabase.child("TotalData").setValue(ad);
    }
}