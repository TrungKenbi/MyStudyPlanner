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
import vn.edu.tdmu.msp.ItemExamination;
import vn.edu.tdmu.msp.R;

public class ExaminationAdapter extends ArrayAdapter<ItemExamination> {
    List<ItemExamination> examinationList;

    public ExaminationAdapter(@NonNull Context context, int resource, @NonNull List<ItemExamination> objects) {
        super(context, resource, objects);
        examinationList = objects;
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
        v = inflater.inflate(R.layout.list_examination_items, null);
        TextView txtDayOfWeek = v.findViewById(R.id.txtDayOfWeek);
        TextView txtTime = v.findViewById(R.id.txtTime);
        TextView txtDate = v.findViewById(R.id.txtDate);
        TextView txtSubject = v.findViewById(R.id.txtTenMonHoc);
        TextView txtRoom = v.findViewById(R.id.txtPhongHoc);
        TextView txtTimeUp = v.findViewById(R.id.txtTimeUp);

        txtDayOfWeek.setText(examinationList.get(position).getDayOfWeek());
        txtTime.setText(examinationList.get(position).getTime());
        txtDate.setText(examinationList.get(position).getDate());
        txtSubject.setText(examinationList.get(position).getSubject());
        txtRoom.setText(examinationList.get(position).getRoom());
        txtTimeUp.setText(examinationList.get(position).getTimeUp());
        return v;
    }
}
