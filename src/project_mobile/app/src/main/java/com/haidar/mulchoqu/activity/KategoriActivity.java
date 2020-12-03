package com.haidar.mulchoqu.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;


import com.haidar.mulchoqu.R;
import com.haidar.mulchoqu.adapter.GridCategoryAdapter;
import com.haidar.mulchoqu.databinding.ActivitySetBinding;

import java.util.ArrayList;

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

        ArrayList<String> catList = new ArrayList<>();

        catList.add("Animal");
        catList.add("cat 2");
        catList.add("cat 3");
        catList.add("cat 4");
        catList.add("cat 5");
        catList.add("cat 6");


        GridCategoryAdapter adapter = new GridCategoryAdapter(catList);
        dataList.setAdapter(adapter);
        dataList.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            KategoriActivity.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}