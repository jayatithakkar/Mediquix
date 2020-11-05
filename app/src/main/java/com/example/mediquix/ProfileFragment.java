package com.example.mediquix;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileFragment extends Fragment {

    DatabaseReference dr;
    TextView tv,lg;
    LinearLayout ll;
    ImageView vi, lgo;
    FirebaseAuth h;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview = inflater.inflate(R.layout.fragment_profile, container, false);

        dr= FirebaseDatabase.getInstance().getReference("Info");
        h=FirebaseAuth.getInstance();

        tv=(TextView) rootview.findViewById(R.id.hiii);
        lg=(TextView) rootview.findViewById(R.id.lg1);

        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                logout();
            }
        });

        vi=(ImageView) rootview.findViewById(R.id.hiii1);
        lgo=(ImageView) rootview.findViewById(R.id.lg2);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Viewj.class);
                startActivity(i);
            }
        });






        return rootview;
    }

    private void logout(){
        Intent i = new Intent(getActivity(), MainActivity.class);
        startActivity(i);
    }
}