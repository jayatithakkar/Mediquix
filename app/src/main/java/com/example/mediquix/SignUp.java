package com.example.mediquix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    EditText name,mail,pass,ctnum;
    RadioButton mle,fml,other;
    Button signup;
    DatabaseReference ref;
    String gndr;
    FirebaseAuth auth;

    String nme;
    String email;
    String pas;
    long cnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name=(EditText)findViewById(R.id.su_name);
        mail=(EditText)findViewById(R.id.et_mail);
        pass=(EditText)findViewById(R.id.et_pass);
        ctnum=(EditText)findViewById(R.id.et_num);
        mle=(RadioButton)findViewById(R.id.male);
        fml=(RadioButton)findViewById(R.id.female);
        other=(RadioButton)findViewById(R.id.radio_other);
        signup=(Button)findViewById(R.id.btn);

        ref=FirebaseDatabase.getInstance().getReference("Info");
        auth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nme=name.getText().toString();
                email=mail.getText().toString();
                pas=pass.getText().toString();
                cnum=Long.parseLong(ctnum.getText().toString());

                if(mle.isChecked()){
                    gndr="Male";
                }
                if(fml.isChecked()){
                    gndr="Female";
                }
                if(other.isChecked()){
                    gndr="Other";
                }

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(SignUp.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(nme)){
                    Toast.makeText(SignUp.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(pas)){
                    Toast.makeText(SignUp.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(String.valueOf(cnum))){
                    Toast.makeText(SignUp.this, "Please Enter Contact Number", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(gndr)){
                    Toast.makeText(SignUp.this, "Please Select your Gender", Toast.LENGTH_SHORT).show();
                }
                auth.createUserWithEmailAndPassword(email, pas)
                        .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    //Data info = new Data(nme, email, gndr, cnum);

                                    /*FirebaseDatabase.getInstance().getReference("Info").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            Toast.makeText(SignUp.this, "Regestration Completed!", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(), HealthData.class));

                                        }
                                    });*/

                                    Intent i1= new Intent(getApplicationContext(), HealthData.class);
                                    i1.putExtra("h1", nme);
                                    i1.putExtra("h2", email);
                                    i1.putExtra("h3", gndr);
                                    i1.putExtra("h4", cnum);
                                    startActivity(i1);

                                } else {
                                    // If sign in fails, display a message to the user.

                                }

                                // ...
                            }
                        });

            }
        });

    }
}