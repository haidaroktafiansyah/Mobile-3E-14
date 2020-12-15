package com.haidar.mulchoqu.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.MenuItem;


import com.haidar.mulchoqu.R;
import com.haidar.mulchoqu.adapter.GridCategoryAdapter;
import com.haidar.mulchoqu.databinding.ActivitySetBinding;
import com.haidar.mulchoqu.model.kategori.Kategori;
import com.haidar.mulchoqu.model.kategori.TriviaCategoryModel;
import com.haidar.mulchoqu.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KategoriActivity extends AppCompatActivity {

    private RecyclerView dataList;
    ActivitySetBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_kategori);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Categories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dataList = findViewById(R.id.rv_category);

        getKategoriFromApi();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            KategoriActivity.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private List<TriviaCategoryModel> daftar_kategori;

    private void getKategoriFromApi(){
        ApiService.endpoint().getKategori().enqueue(new Callback<Kategori>() {
            @Override
            public void onResponse(Call<Kategori> call, Response<Kategori> response) {
                daftar_kategori = response.body().getTriviaCategories();
                setKategori();
            }

            @Override
            public void onFailure(Call<Kategori> call, Throwable t) {

            }
        });
    }

    ArrayList<String> catList = new ArrayList<>();
    ArrayList<String> catList_id = new ArrayList<>();
    private void setKategori(){

        for(int i=0; i<daftar_kategori.size(); i++){
            catList.add(daftar_kategori.get(i).getName());
            catList_id.add(String.valueOf(daftar_kategori.get(i).getId()));
        }

        GridCategoryAdapter adapter = new GridCategoryAdapter(catList,catList_id);
        dataList.setAdapter(adapter);
        dataList.setLayoutManager(new GridLayoutManager(this, 2));
    }
}