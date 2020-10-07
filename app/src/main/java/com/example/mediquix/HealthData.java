package com.example.mediquix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HealthData extends AppCompatActivity{

    EditText age, wgt, bgrp;
    Button signup;
    DatabaseReference ref;
    FirebaseAuth auth;

    String Name,Email,Gender;
    long Contact;

    int ag;
    long wg;
    String bgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_data);

        age=(EditText) findViewById(R.id.su_age);
        wgt=(EditText) findViewById(R.id.wgt);
        bgrp=(EditText)findViewById(R.id.bgrp);
        signup=(Button)findViewById(R.id.signup);

        ref= FirebaseDatabase.getInstance().getReference("Info");
        auth = FirebaseAuth.getInstance();

        Intent i= getIntent();
        Name=i.getStringExtra("h1");
        Email=i.getStringExtra("h2");
        Gender=i.getStringExtra("h3");
        Contact=i.getLongExtra("h4",0);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ag=Integer.parseInt(age.getText().toString());
                wg=Long.parseLong(wgt.getText().toString());
                bgr=bgrp.getText().toString();



                if(TextUtils.isEmpty(String.valueOf(ag))){
                    Toast.makeText(HealthData.this, "Please Enter Age", Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(String.valueOf(wg))){
                    Toast.makeText(HealthData.this, "Please Enter Weight", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(bgr)){
                    Toast.makeText(HealthData.this, "Please Enter Blood Group", Toast.LENGTH_SHORT).show();
                }



                                    Data info = new Data(Name, Email, Gender, Contact, bgr,ag,wg);

                                    FirebaseDatabase.getInstance().getReference("Info").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            Toast.makeText(HealthData.this, "Registration Completed!", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                                        }
                                    });




            }
        });
    }


}