package com.haidar.mulchoqu.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haidar.mulchoqu.R;
import com.haidar.mulchoqu.activity.SetActivity;

import java.util.ArrayList;
import java.util.Random;

public class GridCategoryAdapter extends RecyclerView.Adapter<GridCategoryAdapter.ViewHolder> {

    private ArrayList<String> categories = new ArrayList<>();
    private ArrayList<String> id_categories = new ArrayList<>();

    public GridCategoryAdapter(ArrayList<String> categories, ArrayList<String> categories_id) {
        this.categories.addAll(categories);
        this.id_categories.addAll(categories_id);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_item_layout, parent, false);

        Random rnd = new Random();
        int color = Color.argb(255,rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255));
        view.setBackgroundColor(color);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvCategoryTitle.setText(categories.get(position));
        holder.tvCategoryTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Info", "Button Pressed");
                Intent intent = new Intent(holder.tvCategoryTitle.getContext(), SetActivity.class);
                intent.putExtra("kategori",categories.get(position));
                intent.putExtra("id_kategori",id_categories.get(position));
                holder.tvCategoryTitle.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView tvCategoryTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCategoryTitle = itemView.findViewById(R.id.categori_name);

        }
    }
}
