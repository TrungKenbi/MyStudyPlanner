package vn.edu.tdmu.msp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.tdmu.msp.ItemActivityHome;
import vn.edu.tdmu.msp.ItemSubjectHome;
import vn.edu.tdmu.msp.R;
import vn.edu.tdmu.msp.adapter.MyAdapter;
import vn.edu.tdmu.msp.adapter.MySubjectHomeAdapter;
import vn.edu.tdmu.msp.adapter.TimetableAdapter;
import vn.edu.tdmu.msp.data.TDMUService;
import vn.edu.tdmu.msp.data.model.Subject;
import vn.edu.tdmu.msp.data.model.TDMUResponse;
import vn.edu.tdmu.msp.utils.ApiUtils;
import vn.edu.tdmu.msp.utils.DateHelper;

public class HomeFragment extends Fragment {

    ListView listActivity, listSubjectHome;
    List<ItemActivityHome> activityList;

    private TDMUService mService;
    private TimetableAdapter mAdapter;
    List<Subject> timetable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Load list môn học ở trang home
        listSubjectHome = view.findViewById(R.id.listSubjectHome);

        mService = ApiUtils.getTDMUService();
        loadTimetable();


        //Load list hoạt động ở trang home
        listActivity = view.findViewById(R.id.listActivity);
        activityList = new ArrayList<>();
        activityList.add(new ItemActivityHome("Nhập môn phát triển game", "Báo cáo cuối kỳ"));
        activityList.add(new ItemActivityHome("Nhập môn phát triển game", "Báo cáo cuối kỳ"));
        activityList.add(new ItemActivityHome("Nhập môn phát triển game", "Báo cáo cuối kỳ"));
        activityList.add(new ItemActivityHome("Nhập môn phát triển game", "Báo cáo cuối kỳ"));

        MyAdapter myAdapter = new MyAdapter(getContext(), R.layout.listactivity_items, activityList);
        listActivity.setAdapter(myAdapter);

        return view;
    }


    public void loadTimetable() {
        mService.getStudentInfo("1824801030053")
                .enqueue(new Callback<TDMUResponse>() {
                    @Override
                    public void onResponse(Call<TDMUResponse> call, Response<TDMUResponse> response) {
                        if (response.isSuccessful()) {

                            List<Subject> subjects = new ArrayList<>();
                            int dayNumber = DateHelper.getDayNumber();
                            for (Subject subject : response.body().getTimetable()) {
                                if (subject.getDayOfWeek() == dayNumber)
                                    subjects.add(subject);
                            }

                            timetable = subjects;
                            mAdapter = new TimetableAdapter(getContext(), R.layout.list_subject_timetable_items, timetable);
                            listSubjectHome.setAdapter(mAdapter);


                            if (subjects.size() > 2) {
                                int dps = 210;
                                final float scale = getContext().getResources().getDisplayMetrics().density;
                                int pixels = (int) (dps * scale + 0.5f);

                                // Change Height of ListView
                                ViewGroup.LayoutParams params = listSubjectHome.getLayoutParams();
                                params.height = pixels;
                                listSubjectHome.setLayoutParams(params);
                            }

                            Log.d("MainActivity", "Timetable loaded from API");
                        } else {
                            int statusCode = response.code();
                            Log.d("MainActivity", String.format("statusCode: " + statusCode));
                            // handle request errors depending on status code
                        }
                    }

                    @Override
                    public void onFailure(Call<TDMUResponse> call, Throwable t) {
                        if (t instanceof IOException) {
                            Toast.makeText(getActivity(), "Hông có mạng bạn ơi !!!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getActivity(), "Lỗi khác rồi bây ơiiiii", Toast.LENGTH_SHORT).show();
                        }
                        Log.d("MainActivity", "error loading from API");
                    }
                });
    }
}