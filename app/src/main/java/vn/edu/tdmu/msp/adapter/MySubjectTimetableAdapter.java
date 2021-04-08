package vn.edu.tdmu.msp.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import vn.edu.tdmu.msp.ItemSubjectHome;
import vn.edu.tdmu.msp.ItemSubjectTimetable;
import vn.edu.tdmu.msp.R;

public class MySubjectTimetableAdapter extends ArrayAdapter<ItemSubjectTimetable> {
    List<ItemSubjectTimetable> subjectTimetableList;

    public MySubjectTimetableAdapter(@NonNull Context context, int resource, @NonNull List<ItemSubjectTimetable> objects) {
        super(context, resource, objects);
        subjectTimetableList = objects;
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
        v = inflater.inflate(R.layout.list_subject_timetable_items, null);
        TextView txtTime = v.findViewById(R.id.txtTime);
        TextView txtSubjectName = v.findViewById(R.id.txtTenMonHoc);
        TextView txtRoom = v.findViewById(R.id.txtPhongHoc);

        txtTime.setText(subjectTimetableList.get(position).getTime());
        txtSubjectName.setText(subjectTimetableList.get(position).getSubjectName());
        txtRoom.setText(subjectTimetableList.get(position).getRoom());
        return v;
    }
}
