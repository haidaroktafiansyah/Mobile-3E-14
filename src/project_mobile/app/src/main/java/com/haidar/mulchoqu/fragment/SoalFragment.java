package com.haidar.mulchoqu.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.haidar.mulchoqu.R;
import com.haidar.mulchoqu.adapter.GridSoalAdapter;
import com.haidar.mulchoqu.databinding.FragmentSoalBinding;
import com.haidar.mulchoqu.model.POJOExample;
import com.haidar.mulchoqu.model.POJOResult;
import com.haidar.mulchoqu.model.SoalModel;
import com.haidar.mulchoqu.model.SoalResult;
import com.haidar.mulchoqu.retrofit.ApiService;
import com.haidar.mulchoqu.viewmodel.DataViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        dataList = view.findViewById(R.id.grid_view);

        GridSoalAdapter adapter = new GridSoalAdapter(20);
        dataList.setAdapter(adapter);

        dataList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                binding.getViewmodel().setClicked(String.valueOf(i + 1));
                binding.clicked.setText(viewModel.getClicked());
            }
        });

        getDataFromApi();
    }

    private final String Tag = "Data_Pertanyaan";

    private void getDataFromApi() {

        ApiService.endpoint().getData().enqueue(new Callback<SoalModel>() {
            @Override
            public void onResponse(Call<SoalModel> call, Response<SoalModel> response) {
                List<SoalResult> daftar_soal = response.body().getResults();
                if (daftar_soal.size() > 0) {
                    Log.d(Tag, daftar_soal.get(0).getQuestion());
                }else {
                    Log.d(Tag, "Data null");
                }
            }

            @Override
            public void onFailure(Call<SoalModel> call, Throwable t) {
                Log.d(Tag, t.getMessage());
            }
        });
    }
}