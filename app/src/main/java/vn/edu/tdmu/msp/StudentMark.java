package vn.edu.tdmu.msp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import vn.edu.tdmu.msp.adapter.ExaminationAdapter;
import vn.edu.tdmu.msp.adapter.StudentMarkAdapter;
import vn.edu.tdmu.msp.data.model.Subject;

public class StudentMark extends AppCompatActivity {
    ListView listStudentMark;
    List<ItemStudentMark> studentMark;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_mark);

        listStudentMark = findViewById(R.id.listStudentMark);
        studentMark = new ArrayList<>();
        studentMark.add(new ItemStudentMark("TI137", "Cơ sở lập trình (3+1)", "9.5", "9.0", "Đạt", "9.2"));
        studentMark.add(new ItemStudentMark("TI155", "Nhập môn ngành công nghệ thông tin (2+1)", "8.5", "10.0", "Đạt", "9.6"));
        StudentMarkAdapter studentMarkAdapter = new StudentMarkAdapter(this, R.layout.list_student_mark_items, studentMark);
        listStudentMark.setAdapter(studentMarkAdapter);
    }
}
