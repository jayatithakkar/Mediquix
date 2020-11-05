package com.example.mediquix;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CovidFragment extends Fragment {

    EditText tsh, t3, t4;
    String ts, tt, tf;
    TextView tv, clk;

    Button sb;
    View v;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_covid, container, false);

        tsh=v.findViewById(R.id.ettsh);
        t3=v.findViewById(R.id.ett3);
        t4=v.findViewById(R.id.ett4);

        tv=v.findViewById(R.id.rs);
        clk=v.findViewById(R.id.rs2);



        sb=v.findViewById(R.id.btnt4);

        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ts=tsh.getText().toString();
                tt=t3.getText().toString();
                tf=t4.getText().toString();
                if(Double.parseDouble(ts)<0.4){
                    if(Double.parseDouble(tt)>220 && Double.parseDouble(tf)>1.8){
                        tv.setVisibility(View.VISIBLE);
                        clk.setVisibility(View.VISIBLE);
                        clk.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(getActivity(), test2.class);
                                startActivity(i);
                            }
                        });
                        tv.setText("Results: Hyperthyroidism");
                    }
                }

                else if(Double.parseDouble(ts)>4){
                    if(Double.parseDouble(tt)<80 && Double.parseDouble(tf)<0.8){
                        tv.setVisibility(View.VISIBLE);
                        clk.setVisibility(View.VISIBLE);
                        clk.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(getActivity(), test2.class);
                                startActivity(i);
                            }
                        });
                        tv.setText("Results: Hypothyroidism");
                    }
                }

                else if(Double.parseDouble(ts)<4 && Double.parseDouble(ts)>0.4){
                    if(Double.parseDouble(tt)>80 && Double.parseDouble(tf)>0.8 && Double.parseDouble(tt)<220 && Double.parseDouble(tf)<1.8){
                        tv.setVisibility(View.VISIBLE);

                        tv.setText("Results: NORMAL");
                    }
                }

                else{
                    Toast.makeText(getActivity(),"Enter proper values", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }
}