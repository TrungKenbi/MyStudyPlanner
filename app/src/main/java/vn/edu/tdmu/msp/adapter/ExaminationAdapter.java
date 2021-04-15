package vn.edu.tdmu.msp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import vn.edu.tdmu.msp.R;
import vn.edu.tdmu.msp.data.model.Exam;

public class ExaminationAdapter extends ArrayAdapter<Exam> {
    List<Exam> examinationList;

    public ExaminationAdapter(@NonNull Context context, int resource, @NonNull List<Exam> objects) {
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

        Date date;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = format.parse(examinationList.get(position).getDay());
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
            txtDayOfWeek.setText(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        txtTime.setText(examinationList.get(position).getTime());
        txtDate.setText(examinationList.get(position).getDay());
        txtSubject.setText(examinationList.get(position).getName());
        txtRoom.setText(examinationList.get(position).getRoom());
        txtTimeUp.setText(examinationList.get(position).getMinutes()); // Duration mới đúng nha
        return v;
    }
}
