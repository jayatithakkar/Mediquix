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

import java.util.ArrayList;
import java.util.List;


public class ChildFragment extends Fragment{

    RecyclerView recyclerView;

    List<Child> movieList;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_child, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);

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
        movieList.add(new Child("child",  "2019"));
    }

}