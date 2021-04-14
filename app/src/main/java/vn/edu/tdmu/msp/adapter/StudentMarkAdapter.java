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

import vn.edu.tdmu.msp.ItemStudentMark;
import vn.edu.tdmu.msp.R;
import vn.edu.tdmu.msp.data.model.Subject;
import vn.edu.tdmu.msp.utils.DateHelper;

public class StudentMarkAdapter extends ArrayAdapter<ItemStudentMark> {
    private List<ItemStudentMark> studentMark;

    public StudentMarkAdapter(@NonNull Context context, int resource, @NonNull List<ItemStudentMark> objects) {
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

        txtSubjectCode.setText(studentMark.get(position).getSubjectCode());
        txtSubjectName.setText(studentMark.get(position).getSubjectName());
        txtMiddleMark.setText(studentMark.get(position).getMiddleMark());
        txtFinalMark.setText(studentMark.get(position).getFinalMark());
        txtStatus.setText(studentMark.get(position).getStatus());
        txtAverageMark.setText(studentMark.get(position).getAverageMark());

        return view;
    }
}
