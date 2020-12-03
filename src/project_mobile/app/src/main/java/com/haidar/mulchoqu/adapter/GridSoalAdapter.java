package com.haidar.mulchoqu.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.haidar.mulchoqu.R;
import com.haidar.mulchoqu.activity.SetActivity;

import org.w3c.dom.Text;

public class GridSoalAdapter extends BaseAdapter{

    private int numOfSets;

    public GridSoalAdapter(int numOfSets) {
        this.numOfSets = numOfSets;
    }

    @Override
    public int getCount() {
        return numOfSets;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View newView;
        if (view == null) {
            newView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.set_item_layout, viewGroup, false);
        } else {
            newView = view;
        }
        ((TextView) newView.findViewById(R.id.set_soal)).setText(String.valueOf(i+1));

        return newView;
    }

}
