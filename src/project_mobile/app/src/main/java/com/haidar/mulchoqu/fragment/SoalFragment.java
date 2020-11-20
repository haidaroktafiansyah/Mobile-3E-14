package com.haidar.mulchoqu.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.haidar.mulchoqu.R;
import com.haidar.mulchoqu.activity.SetActivity;
import com.haidar.mulchoqu.adapter.GridSetsAdapter;
import com.haidar.mulchoqu.databinding.FragmentSoalBinding;
import com.haidar.mulchoqu.viewmodel.DataViewModel;

public class SoalFragment extends Fragment {
    private GridView dataList;
    private DataViewModel viewModel;
    FragmentSoalBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_soal, container, false);

        binding.setLifecycleOwner(this);
        viewModel = new ViewModelProvider(requireActivity()).get(DataViewModel.class);

        binding.setViewmodel(viewModel);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataList= view.findViewById(R.id.grid_view);

        GridSetsAdapter adapter = new GridSetsAdapter(20);
        dataList.setAdapter(adapter);

        binding.clicked.setText(viewModel.getClicked());

        dataList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                binding.getViewmodel().setClicked(String.valueOf(i+1));
            }
        });
    }
}