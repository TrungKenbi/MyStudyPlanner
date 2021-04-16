package vn.edu.tdmu.msp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import vn.edu.tdmu.msp.R;
import vn.edu.tdmu.msp.data.model.Mark;

public class StudentMarkAdapter extends ArrayAdapter<Mark> {
    private List<Mark> studentMark;

    public StudentMarkAdapter(@NonNull Context context, int resource, @NonNull List<Mark> objects) {
        super(context, resource, objects);
        studentMark = objects;
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
        view = inflater.inflate(R.layout.list_student_mark_items, null);
        TextView txtSubjectCode = view.findViewById(R.id.txtSubjectCode);
        TextView txtSubjectName = view.findViewById(R.id.txtSubjectName);
        TextView txtMiddleMark = view.findViewById(R.id.txtMiddleMark);
        TextView txtFinalMark = view.findViewById(R.id.txtFinalMark);
        TextView txtStatus = view.findViewById(R.id.txtStatus);
        TextView txtAverageMark = view.findViewById(R.id.txtAverageMark);

        Mark mark = studentMark.get(position);

        txtSubjectCode.setText(mark.getId());
        txtSubjectName.setText(mark.getName());
        txtMiddleMark.setText(mark.getmPoint());
        txtFinalMark.setText(mark.getePoint());

        try {
            if (mark.getAvgPoint().equals("Đạt") || Float.valueOf(mark.getAvgPoint()) > 5.0f)
                txtStatus.setText("Đạt");
            else if (!mark.getmPoint().equals("") || !mark.getePoint().equals("")) {
                txtStatus.setText("Không Đạt");
                txtStatus.setTextColor(Color.RED);
            }
        } catch (NumberFormatException ex) {
            txtStatus.setText("");
        }

        if (!mark.getAvgPoint().equals("Đạt"))
            txtAverageMark.setText(mark.getAvgPoint());

        return view;
    }
}
