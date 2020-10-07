package com.example.trialschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TotalData extends AppCompatActivity {
    private Button btn2;
    private EditText totalhr;
    private EditText totalsubj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_data);
        totalsubj= (EditText) findViewById(R.id.totalsub);
        totalhr=(EditText) findViewById(R.id.totalhrs);



        btn2= (Button) findViewById(R.id.add_data_further);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s=totalsubj.getText().toString();
                Intent intent1=new Intent(getApplicationContext(),FinalData.class);
                intent1.putExtra("hi",s);
                startActivity(intent1);
            }
        });

    }
}