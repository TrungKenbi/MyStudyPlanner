package com.example.mystudyplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Item> {
    ArrayList<Item> activityList = new ArrayList<Item>();

    public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Item> objects) {
        super(context, resource, objects);
        activityList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.listactivity_items, null);
        TextView txtTenMonHoc = (TextView) v.findViewById(R.id.txtTenMonHoc);
        TextView txtNoiDung = (TextView) v.findViewById(R.id.txtNoiDung);

        txtTenMonHoc.setText(activityList.get(position).getTenMH());
        txtNoiDung.setText(activityList.get(position).getNoiDung());
        return v;
    }
}

