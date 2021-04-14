package vn.edu.tdmu.msp;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class StudentInfo extends AppCompatActivity implements View.OnClickListener {
    ListView infoStudent;
    List<ItemStudentInfo> studentInfo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_student);

        studentInfo = new ArrayList<>();
        studentInfo.add(new ItemStudentInfo("Trần Minh Hiếu","1824801030067","Nam",
                "12/08/2000", "Bệnh viện đa khoa tỉnh Bình Dương",
                "D18PM01", "ĐH Kỹ thuật phần mềm", "Viện Kỹ thuật - Công nghệ"));
    }

    @Override
    public void onClick(View v) {

    }
}
