package com.example.mediquix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class View extends AppCompatActivity {

    TextView name,mail,weight,age,bg,cnt;
    private final String TAG = this.getClass().getName().toUpperCase();
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private Map<String, String> userMap;
    private String userid;
    private static final String USERS = "Info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        name=findViewById(R.id.vname);
        mail=findViewById(R.id.vmail);
        weight=findViewById(R.id.vweight);
        age=findViewById(R.id.vage);
        bg=findViewById(R.id.vbg);
        cnt=findViewById(R.id.vct);

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = rootRef.child(USERS);
        Log.v("USERID", userRef.getKey());

        userRef.addValueEventListener(new ValueEventListener() {
            String sname, smail, swgt, sage,sbg,sct;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot keyId: dataSnapshot.getChildren()) {

                        sname = keyId.child("Name").getValue(String.class);
                        smail = keyId.child("Email").getValue(String.class);
                        swgt = keyId.child("Weight").getValue(String.class);
                        sage = keyId.child("Age").getValue(String.class);
                        sct = keyId.child("Contact").getValue(String.class);
                        sbg = keyId.child("Blood_Group").getValue(String.class);
                        break;

                }
                name.setText(sname);
                weight.setText(swgt);
                age.setText(sage);
                mail.setText(smail);
                bg.setText(sbg);
                cnt.setText(sct);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
}