package com.example.mediquix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class HomePage extends AppCompatActivity {

    ChipNavigationBar nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        nav=findViewById(R.id.bottom_nav);
        nav.setItemSelected(R.id.home, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.home, new BlankFragment()).commit();
        bottomMenu();
    }

    private void bottomMenu(){

        nav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment f= null;
                switch(i){
                    case R.id.home:
                        f=new BlankFragment();
                        break;
                    case R.id.chld:
                        f=new ChildFragment();
                        break;
                    case R.id.covid:
                        f=new CovidFragment();
                        break;
                    case R.id.prof:
                        f=new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.home, f).commit();
            }
        });

    }
}