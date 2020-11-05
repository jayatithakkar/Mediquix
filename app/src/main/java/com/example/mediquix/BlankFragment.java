package com.example.mediquix;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v= inflater.inflate(R.layout.fragment_blank, container, false);
        ImageSlider idm = v.findViewById(R.id.sldr);

        /*https://images.app.goo.gl/en3jr85tXJuxBTDq9.jpg*/
        List<SlideModel> md = new ArrayList<>();
        md.add(new SlideModel("R.drawable.tst1", "Child Vaccinations"));
        md.add(new SlideModel("R.drawable.chld", "Medical Tests"));
        idm.setImageList(md, true);

        idm.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fg=null;
                if(i==0){
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