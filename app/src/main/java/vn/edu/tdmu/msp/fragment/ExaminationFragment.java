package vn.edu.tdmu.msp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.tdmu.msp.R;
import vn.edu.tdmu.msp.adapter.ExaminationAdapter;
import vn.edu.tdmu.msp.data.TDMUService;
import vn.edu.tdmu.msp.data.model.Exam;
import vn.edu.tdmu.msp.utils.ApiUtils;

public class ExaminationFragment extends Fragment {

    private TDMUService mService;
    ListView listExamination;
    List<Exam> examinationList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_examination, container, false);

        listExamination = view.findViewById(R.id.listExamination);
        examinationList = new ArrayList<>();
        mService = ApiUtils.getTDMUService();

        mService.getStudentExam("1824801030067", "hieu123leggo@456")
                .enqueue(new Callback<List<Exam>>() {
                    @Override
                    public void onResponse(Call<List<Exam>> call, Response<List<Exam>> response) {
                        if (response.isSuccessful()) {
                            examinationList = response.body();
                            ExaminationAdapter examinationAdapter = new ExaminationAdapter(getContext(), R.layout.list_examination_items, examinationList);
                            listExamination.setAdapter(examinationAdapter);
                        }
                    }
                    @Override
                    public void onFailure(Call<List<Exam>> call, Throwable t) {
                    }
                });
        return view;
    }
}