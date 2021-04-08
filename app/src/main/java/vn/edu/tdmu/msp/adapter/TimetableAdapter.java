package vn.edu.tdmu.msp.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import vn.edu.tdmu.msp.R;
import vn.edu.tdmu.msp.data.model.Subject;
import vn.edu.tdmu.msp.fragment.HomeFragment;
import vn.edu.tdmu.msp.utils.DateHelper;

public class TimetableAdapter extends ArrayAdapter<Subject> {
    private List<Subject> timetable;

    public TimetableAdapter(@NonNull Context context, int resource, @NonNull List<Subject> timetable) {
        super(context, resource, timetable);
        this.timetable = timetable;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_subject_timetable_items, null);
        TextView txtTime = view.findViewById(R.id.txtTime);
        TextView txtSubjectName = view.findViewById(R.id.txtTenMonHoc);
        TextView txtRoom = view.findViewById(R.id.txtPhongHoc);

        txtTime.setText(DateHelper.getDayAsText(timetable.get(position).getTimeStart()));
        txtSubjectName.setText(timetable.get(position).getSubjectName());
        txtRoom.setText(timetable.get(position).getRoomName());
        return view;
    }

    public void updateTimetable(List<Subject> timetable) {
        for (Subject subject : timetable)
            Log.d("updateTimetable", subject.getSubjectName());
        this.timetable = timetable;
        notifyDataSetChanged();
    }
}
