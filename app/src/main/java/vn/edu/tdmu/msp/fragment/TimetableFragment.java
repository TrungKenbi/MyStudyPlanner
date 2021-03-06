package vn.edu.tdmu.msp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.tdmu.msp.LoginActivity;
import vn.edu.tdmu.msp.R;
import vn.edu.tdmu.msp.adapter.TimetableAdapter;
import vn.edu.tdmu.msp.data.TDMUService;
import vn.edu.tdmu.msp.data.model.Subject;
import vn.edu.tdmu.msp.data.model.TDMUResponse;
import vn.edu.tdmu.msp.utils.ApiUtils;

public class TimetableFragment extends Fragment {

    private TDMUService mService;
    TimetableAdapter mAdapter;
    ListView lstTimetable;
    List<Subject> timetable;

    Button btnAddSubject;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_timetable, container, false);

        btnAddSubject = view.findViewById(R.id.btnAddSubject);
        btnAddSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        lstTimetable = view.findViewById(R.id.listSubjectTimetable);
        mService = ApiUtils.getTDMUService();
        loadTimetable();

        return view;
    }

    public void loadTimetable() {
        mService.getStudentInfo(LoginActivity.USERNAME)
                .enqueue(new Callback<TDMUResponse>() {
            @Override
            public void onResponse(Call<TDMUResponse> call, Response<TDMUResponse> response) {
                if (response.isSuccessful()) {
                    timetable = response.body().getTimetable();
                    mAdapter = new TimetableAdapter(getContext(), R.layout.list_subject_timetable_items, timetable);
                    lstTimetable.setAdapter(mAdapter);
                    Log.d("MainActivity", "Timetable loaded from API");
                } else {
                    int statusCode = response.code();
                    Log.d("MainActivity", String.format("statusCode: " + statusCode));
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<TDMUResponse> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
            }
        });
    }
}