package com.haidar.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.haidar.myapplication.R;
import com.haidar.myapplication.adapter.Adapter1;

import java.util.LinkedList;

public class FirstFragment extends Fragment {

    private final LinkedList<String> mWordList = new LinkedList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    private RecyclerView mRecycleview;
    private RecyclerView.Adapter mAdapter;
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for(int i = 0 ; i<20; i++){
            mWordList.add(String.valueOf(i));
        }

        this.mRecycleview = view.findViewById(R.id.rv_androidx);
        this.mAdapter = new Adapter1(mWordList);
        this.mRecycleview.setAdapter(mAdapter);
        mRecycleview.setLayoutManager(new LinearLayoutManager(view.getContext()));



        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}