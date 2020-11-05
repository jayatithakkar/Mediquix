package com.example.mediquix;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.fragment.app.Fragment;

        import android.content.Intent;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.util.Map;

public class Viewj extends AppCompatActivity {

    EditText name,mail,weight,age,bg,cnt;
    private final String TAG = this.getClass().getName().toUpperCase();
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private Map<String, String> userMap;
    private String userid;
    private static final String USERS = "Info";
    String nme1;
    String email1;
    long cnum1;
    int ag1;
    long wg1;
    String bgr1;


    Button sv;

    DatabaseReference ref;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewj);

        name=findViewById(R.id.vname);
        mail=findViewById(R.id.vmail);
        weight=findViewById(R.id.vweight);
        age=findViewById(R.id.vage);
        bg=findViewById(R.id.vbg);
        cnt=findViewById(R.id.vct);



        sv=findViewById(R.id.savebtm);

        ref=FirebaseDatabase.getInstance().getReference("Info");
        auth = FirebaseAuth.getInstance();

        sv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nme1=name.getText().toString();
                email1=mail.getText().toString();
                cnum1=Long.parseLong(cnt.getText().toString());
                ag1=Integer.parseInt(age.getText().toString());
                wg1=Long.parseLong(weight.getText().toString());
                bgr1=bg.getText().toString();

                if(TextUtils.isEmpty(email1)){
                    Toast.makeText(Viewj.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(nme1)){
                    Toast.makeText(Viewj.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(String.valueOf(cnum1))){
                    Toast.makeText(Viewj.this, "Please Enter Contact Numbwe", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(String.valueOf(ag1))){
                    Toast.makeText(Viewj.this, "Please Enter Age", Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(String.valueOf(wg1))){
                    Toast.makeText(Viewj.this, "Please Enter Weight", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(bgr1)){
                    Toast.makeText(Viewj.this, "Please Enter Blood Group", Toast.LENGTH_SHORT).show();
                }

                Data info = new Data(nme1, email1,  cnum1, bgr1,ag1,wg1);

                FirebaseDatabase.getInstance().getReference("Info").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        Toast.makeText(Viewj.this, "Registration Completed!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), HomePage.class));

                    }
                });
            }
        });



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
                    swgt = keyId.child("Weight").getValue().toString();
                    sage = keyId.child("Age").getValue().toString();
                    sct = keyId.child("Contact").getValue().toString();
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