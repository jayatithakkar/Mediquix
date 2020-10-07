package com.example.trialschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FinalData extends AppCompatActivity {
    private Button next;
    private Button add;
    private TextView tv;
    int cnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_data);
        cnt=0;

        Intent i=getIntent();
        String p=i.getStringExtra("hi");

        tv=findViewById(R.id.tv);
        final int hello=Integer.parseInt(p);
        add= (Button) findViewById(R.id.add_database);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cnt=cnt+1;
                if(cnt==hello){
                    add.setVisibility(view.INVISIBLE);
                    next.setVisibility(view.VISIBLE);
                }

            }
        });

        next= (Button) findViewById(R.id.final_show);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}