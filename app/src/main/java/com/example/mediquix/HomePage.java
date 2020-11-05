package com.example.mediquix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.WindowManager;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class HomePage extends AppCompatActivity {

    private ChipNavigationBar nav;
    private Fragment f=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_page);

        nav=findViewById(R.id.bottom_navi);
        nav.setItemSelected(R.id.home, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new BlankFragment()).commit();
        bottomMenu();
    }

    private void bottomMenu(){

        nav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {

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
                if(f!=null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, f).commit();
                }
            }
        });

    }
}