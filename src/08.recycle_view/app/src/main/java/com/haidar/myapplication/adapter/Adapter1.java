package com.haidar.myapplication.adapter;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haidar.myapplication.R;

import java.util.LinkedList;

public class Adapter1 extends RecyclerView.Adapter<Adapter1.WordHolder> {

    private final LinkedList<String> mWordList;

    public Adapter1(LinkedList<String> mWordList) {
        this.mWordList = mWordList;
    }

    @NonNull
    @Override
    public Adapter1.WordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mInflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new WordHolder(mInflater);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter1.WordHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.word.setText(mCurrent);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.word.setText(mCurrent+" is clicked");
//              Toast toast = Toast.makeText(view.getContext(), "position "+position+" is clicked" , Toast.LENGTH_SHORT);
//              toast.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    public TextView word;
    class WordHolder extends RecyclerView.ViewHolder{
        TextView word;
        public WordHolder(@NonNull View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.rv_word);
        }
    }


}
