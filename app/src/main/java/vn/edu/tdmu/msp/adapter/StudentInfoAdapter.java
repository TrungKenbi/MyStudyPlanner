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

import vn.edu.tdmu.msp.ItemNewsHome;
import vn.edu.tdmu.msp.ItemStudentInfo;
import vn.edu.tdmu.msp.R;

public class StudentInfoAdapter extends ArrayAdapter<ItemStudentInfo> {
    List<ItemStudentInfo> studenInfo;

    public StudentInfoAdapter(@NonNull Context context, int resource, @NonNull List<ItemStudentInfo> objects) {
        super(context, resource, objects);
        studenInfo = objects;
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
        v = inflater.inflate(R.layout.activity_info_student, null);
        TextView txtName = v.findViewById(R.id.txtStudentName);
        TextView txtCode = v.findViewById(R.id.txtStudentCode);
        TextView txtGender = v.findViewById(R.id.txtGender);
        TextView txtDayOfBirth = v.findViewById(R.id.txtDayOfBirth);
        // TextView txtPlaceOfBirth = v.findViewById(R.id.txtHospital);
        TextView txtClass = v.findViewById(R.id.txtClass);
        TextView txtMajor = v.findViewById(R.id.txtMajor);
        TextView txtFaculty = v.findViewById(R.id.txtFaculty);

        txtName.setText(studenInfo.get(position).getName());
        txtCode.setText(studenInfo.get(position).getCode());
        txtGender.setText(studenInfo.get(position).getGender());
        txtDayOfBirth.setText(studenInfo.get(position).getDayOfBirth());
        // txtPlaceOfBirth.setText(studenInfo.get(position).getPlaceOfBirth());
        txtClass.setText(studenInfo.get(position).getStudentClass());
        txtMajor.setText(studenInfo.get(position).getMajor());
        txtFaculty.setText(studenInfo.get(position).getFaculty());

        return v;
    }
}


