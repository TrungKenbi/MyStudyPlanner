package vn.edu.tdmu.msp;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import vn.edu.tdmu.msp.data.TDMUService;
import vn.edu.tdmu.msp.data.model.Mark;
import vn.edu.tdmu.msp.data.model.TDMUResponse;
import vn.edu.tdmu.msp.utils.ApiUtils;

public class StudentInfo extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_student);

        TextView txtStudentName = findViewById(R.id.txtStudentName);
        TextView txtStudentCode = findViewById(R.id.txtStudentCode);
        TextView txtDayOfBirth = findViewById(R.id.txtDayOfBirth);
        TextView txtClass = findViewById(R.id.txtClass);
        TextView txtMajor = findViewById(R.id.txtMajor);
        TextView txtFaculty = findViewById(R.id.txtFaculty);


        TDMUService mService = ApiUtils.getTDMUService();
        try {
            TDMUResponse response = mService.getStudentInfo(LoginActivity.USERNAME).execute().body();
            txtStudentName.setText(response.getStudentInfo().getName());
            txtStudentCode.setText(response.getStudentInfo().getId());
            txtDayOfBirth.setText(response.getStudentInfo().getBirthday());
            txtClass.setText(response.getStudentInfo().getClass_());
            txtMajor.setText(response.getStudentInfo().getMajor());
            txtFaculty.setText(response.getStudentInfo().getDepartment());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {

    }
}
