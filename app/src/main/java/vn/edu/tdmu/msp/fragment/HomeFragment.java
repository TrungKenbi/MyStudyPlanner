package vn.edu.tdmu.msp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.tdmu.msp.LoginActivity;
import vn.edu.tdmu.msp.NewsActivity;
import vn.edu.tdmu.msp.R;
import vn.edu.tdmu.msp.adapter.NewsAdapter;
import vn.edu.tdmu.msp.adapter.TimetableAdapter;
import vn.edu.tdmu.msp.data.TDMUService;
import vn.edu.tdmu.msp.data.model.News;
import vn.edu.tdmu.msp.data.model.Subject;
import vn.edu.tdmu.msp.data.model.TDMUResponse;
import vn.edu.tdmu.msp.utils.ApiUtils;
import vn.edu.tdmu.msp.utils.DateHelper;

public class HomeFragment extends Fragment {

    ListView listActivity, listSubjectHome;
    List<News> listNews;

    private TDMUService mService;
    private TimetableAdapter mAdapter;
    List<Subject> timetable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Load thời gian
        TextView txtThu = view.findViewById(R.id.tvThu);
        TextView txtNgay = view.findViewById(R.id.tvNgay);

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        txtThu.setText(dayOfTheWeek);
        sdf = new SimpleDateFormat("'Ngày' dd 'tháng' MM 'năm' yyyy");
        txtNgay.setText(sdf.format(d));


        //Load list môn học ở trang home
        listSubjectHome = view.findViewById(R.id.listSubjectHome);

        mService = ApiUtils.getTDMUService();
        loadTimetable();


        //Load list hoạt động ở trang home
        listActivity = view.findViewById(R.id.listNews);
        listNews = new ArrayList<>();


        mService.getNews()
                .enqueue(new Callback<List<News>>() {
                    @Override
                    public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                        if (response.isSuccessful()) {
                            listNews = response.body();
                            NewsAdapter newsAdapter = new NewsAdapter(getContext(), R.layout.listnews_items, listNews);
                            listActivity.setAdapter(newsAdapter);

                            listActivity.setOnItemClickListener((parent, v, position, id) -> {
                                Intent intent = new Intent(getActivity(), NewsActivity.class);

                                intent.putExtra("cat", listNews.get(position).getCatName());
                                intent.putExtra("id", listNews.get(position).getIdName());

                                intent.putExtra("title", listNews.get(position).getName());
                                intent.putExtra("content", listNews.get(position).getDesc());
                                intent.putExtra("viewer", listNews.get(position).getView());
                                intent.putExtra("date", listNews.get(position).getTime());
                                intent.putExtra("imageLink", listNews.get(position).getImg());

                                startActivity(intent);
                            });
                        }
                    }

                    @Override
                    public void onFailure(Call<List<News>> call, Throwable t) {
                    }
                });
        return view;
    }


    public void loadTimetable() {
        mService.getStudentInfo(LoginActivity.USERNAME)
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