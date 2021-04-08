package vn.edu.tdmu.msp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import vn.edu.tdmu.msp.ItemActivityHome;
import vn.edu.tdmu.msp.ItemSubjectHome;
import vn.edu.tdmu.msp.R;

public class MySubjectHomeAdapter extends ArrayAdapter<ItemSubjectHome> {
    List<ItemSubjectHome> subjectHomeList;

    public MySubjectHomeAdapter(@NonNull Context context, int resource, @NonNull List<ItemSubjectHome> objects) {
        super(context, resource, objects);
        subjectHomeList = objects;
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
        v = inflater.inflate(R.layout.list_subject_home_items, null);
        TextView txtMoment = v.findViewById(R.id.txtMoment);
        TextView txtTime = v.findViewById(R.id.txtTime);
        TextView txtTenMH = v.findViewById(R.id.txtTenMonHoc);
        TextView txtPhong = v.findViewById(R.id.txtPhongHoc);

        txtMoment.setText(subjectHomeList.get(position).getMoment());
        txtPhong.setText(subjectHomeList.get(position).getRoom());
        txtTime.setText(subjectHomeList.get(position).getTime());
        txtTenMH.setText(subjectHomeList.get(position).getSubjectName());
        return v;
    }
}
