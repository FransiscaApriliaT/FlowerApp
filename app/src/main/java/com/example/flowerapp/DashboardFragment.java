package com.example.flowerapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class DashboardFragment extends Fragment {

    private RecyclerView rvFlowers;
    private ArrayList<Flower> flowerList = new ArrayList<>();

    public DashboardFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Handle fragment arguments if needed
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        rvFlowers = view.findViewById(R.id.rv_flowers);
        rvFlowers.setHasFixedSize(true);

        // Set layout manager
        rvFlowers.setLayoutManager(new LinearLayoutManager(getContext()));

        // Load data into the list
        flowerList.addAll(FlowerData.getListData());

        // Set up adapter
        ListFlowerAdapter adapter = new ListFlowerAdapter(flowerList);
        rvFlowers.setAdapter(adapter);

        // Handle item clicks
        adapter.setOnItemClickCallback(this::showSelectedFlower);

        return view;
    }

    private void showSelectedFlower(Flower flower) {
        Toast.makeText(getContext(), "You selected " + flower.getName(), Toast.LENGTH_SHORT).show();
    }
}
