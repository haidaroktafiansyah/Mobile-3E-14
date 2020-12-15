package com.haidar.mulchoqu.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.haidar.mulchoqu.R;
import com.haidar.mulchoqu.databinding.ActivitySetBinding;
import com.haidar.mulchoqu.fragment.ScoreboardFragment;
import com.haidar.mulchoqu.fragment.SoalFragment;

public class SetActivity extends AppCompatActivity implements View.OnClickListener {

    private GridView dataList;
    private Button btn_soal;
    private Button btn_scoreboard;

    SoalFragment sf = new SoalFragment();
    ScoreboardFragment scf = new ScoreboardFragment();

    ActivitySetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding  = DataBindingUtil.setContentView(this,R.layout.activity_set);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String title = getIntent().getStringExtra("kategori");
        getSupportActionBar().setTitle(title);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = new Bundle();
        bundle.putString("id_kategori", getIntent().getStringExtra("id_kategori"));
        sf.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,sf).commit();

        binding.buttonSoal.setOnClickListener(this);
        binding.buttonScoreboard.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_soal:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,sf).commit();
                break;
            case R.id.button_scoreboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,scf).commit();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}