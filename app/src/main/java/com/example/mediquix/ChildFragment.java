package com.example.mediquix;

import android.graphics.Movie;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ChildFragment extends Fragment{

    RecyclerView recyclerView;
    TextView tv;

    List<Child> movieList;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_child, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        //tv=v.findViewById(R.id.u);
        //tv.setText("h");

        initData();
        initRecyclerView();

        return v;
    }

    private void initRecyclerView() {
        ChildAdapter movieAdapter = new ChildAdapter(movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(movieAdapter);
    }

    private void initData() {
        movieList = new ArrayList<>();
        movieList.add(new Child("Why Vaccination?", getContext().getResources().getString(R.string.c1)));
        movieList.add(new Child("Birth:",getContext().getResources().getString(R.string.c2) ));
        movieList.add(new Child("1-2 Months:",getContext().getResources().getString(R.string.c3) ));
        movieList.add(new Child("4 Months:", getContext().getResources().getString(R.string.c4)));
        movieList.add(new Child("6 Months:", getContext().getResources().getString(R.string.c5)));
        movieList.add(new Child("7-11 Months:", getContext().getResources().getString(R.string.c6)));
        movieList.add(new Child("12-23 Months:", getContext().getResources().getString(R.string.c7)));
        movieList.add(new Child("2-10 Years:",getContext().getResources().getString(R.string.c8) ));
        movieList.add(new Child("11-12 Years:", getContext().getResources().getString(R.string.c9)));

    }

}