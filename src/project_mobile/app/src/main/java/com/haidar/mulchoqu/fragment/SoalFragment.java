package com.haidar.mulchoqu.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.haidar.mulchoqu.R;
import com.haidar.mulchoqu.adapter.GridSetsAdapter;

public class SoalFragment extends Fragment {
    private GridView dataList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_soal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataList= view.findViewById(R.id.grid_view);

        GridSetsAdapter adapter = new GridSetsAdapter(20);
        dataList.setAdapter(adapter);
    }


}