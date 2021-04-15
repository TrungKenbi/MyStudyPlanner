package vn.edu.tdmu.msp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.tdmu.msp.adapter.StudentMarkAdapter;
import vn.edu.tdmu.msp.data.TDMUService;
import vn.edu.tdmu.msp.data.model.Mark;
import vn.edu.tdmu.msp.utils.ApiUtils;

public class StudentMarkActivity extends AppCompatActivity {

    private TDMUService mService;
    
    ListView listStudentMark;
    List<Mark> studentMark;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_mark);

        mService = ApiUtils.getTDMUService();
        listStudentMark = findViewById(R.id.listStudentMark);
        studentMark = new ArrayList<>();

        mService.getStudentMark("1824801030067", "hieu123leggo@456")
                .enqueue(new Callback<List<Mark>>() {
                    @Override
                    public void onResponse(Call<List<Mark>> call, Response<List<Mark>> response) {
                        if (response.isSuccessful()) {
                            studentMark = response.body();
                            Collections.reverse(studentMark);
                            StudentMarkAdapter studentMarkAdapter = new StudentMarkAdapter(getApplicationContext(), R.layout.list_student_mark_items, studentMark);
                            listStudentMark.setAdapter(studentMarkAdapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Mark>> call, Throwable t) {
                    }
                });
    }
}
