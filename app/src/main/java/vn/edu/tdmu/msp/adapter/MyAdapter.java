package vn.edu.tdmu.msp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import vn.edu.tdmu.msp.ItemNewsHome;
import vn.edu.tdmu.msp.R;

public class MyAdapter extends ArrayAdapter<ItemNewsHome> {
    List<ItemNewsHome> activityList;

    public MyAdapter(@NonNull Context context, int resource, @NonNull List<ItemNewsHome> objects) {
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
        v = inflater.inflate(R.layout.listnews_items, null);
        TextView txtTieuDe = v.findViewById(R.id.txtTieuDe);
        TextView txtNoiDung = v.findViewById(R.id.txtNoiDung);

        txtTieuDe.setText(activityList.get(position).getTieuDe());
        txtNoiDung.setText(activityList.get(position).getNoiDung());
        return v;
    }
}

