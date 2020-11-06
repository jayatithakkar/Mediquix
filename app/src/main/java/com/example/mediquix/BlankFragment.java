package com.example.mediquix;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@Link Fragment} subclass.

 */
public class BlankFragment extends Fragment {
    private ChipNavigationBar nav;
    TextView o4,e4;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v= inflater.inflate(R.layout.fragment_blank, container, false);
        ImageSlider idm = v.findViewById(R.id.sldr);
        o4=v.findViewById(R.id.o4);
        e4=v.findViewById(R.id.e4);

        o4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //o4.setText("done");
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new CovidFragment()).commit();
            }
        });

        e4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //e4.setText("done");
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new CovidFragment()).commit();
            }
        });

        /*https://images.app.goo.gl/en3jr85tXJuxBTDq9.jpg*/
        List<SlideModel> md = new ArrayList<>();
        md.add(new SlideModel(R.drawable.medil,"About Us"));
        md.add(new SlideModel(R.drawable.gucci, "Child Vaccinations"));
        md.add(new SlideModel(R.drawable.tst1, "Medical Tests"));
        idm.setImageList(md, true);

        idm.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fg=null;
                if(i==0){
                    nav=v.findViewById(R.id.bottom_navi);
                    //nav.setItemSelected(R.id.chld, true);
                    Intent u =new Intent(getActivity(), test2.class);
                    startActivity(u);

                }
                else if(i==1){
                    nav=v.findViewById(R.id.bottom_navi);
                    //nav.setItemSelected(R.id.chld, true);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new ChildFragment()).commit();

                }
                else{
                    nav=v.findViewById(R.id.bottom_navi);
                    //nav.setItemSelected(R.id.covid, true);
                    fg=new CovidFragment();
                    replaceFragment(fg);

                }
            }
        });



        return v;
    }

    public void replaceFragment(Fragment fg){

        FragmentTransaction tns=getFragmentManager().beginTransaction();
        tns.replace(R.id.container, fg);
        tns.addToBackStack(null);
        tns.commit();
    }
}