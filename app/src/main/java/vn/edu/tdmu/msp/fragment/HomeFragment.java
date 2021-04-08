package vn.edu.tdmu.msp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import vn.edu.tdmu.msp.ItemActivityHome;
import vn.edu.tdmu.msp.ItemSubjectHome;
import vn.edu.tdmu.msp.R;
import vn.edu.tdmu.msp.adapter.MyAdapter;
import vn.edu.tdmu.msp.adapter.MySubjectHomeAdapter;

public class HomeFragment extends Fragment {

    ListView listActivity, listSubjectHome;
    List<ItemActivityHome> activityList;
    List<ItemSubjectHome> subjectHomeList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Load list môn học ở trang home
        listSubjectHome = view.findViewById(R.id.listSubjectHome);
        subjectHomeList = new ArrayList<>();
        subjectHomeList.add(new ItemSubjectHome("Bây giờ", "7:00", "Phát triển ứng dụng di động (2+1)", "I3.105"));
        subjectHomeList.add(new ItemSubjectHome("Tiếp theo", "9:00", "An toàn và bảo mật thông tin (2+1)", "E2.102"));
        MySubjectHomeAdapter mySubjectHomeAdapter = new MySubjectHomeAdapter(getContext(), R.layout.list_subject_home_items, subjectHomeList);
        listSubjectHome.setAdapter(mySubjectHomeAdapter);

        //Load list hoạt động ở trang home
        listActivity = view.findViewById(R.id.listActivity);
        activityList = new ArrayList<>();
        activityList.add(new ItemActivityHome("Nhập môn phát triển game", "Báo cáo cuối kỳ"));

        MyAdapter myAdapter = new MyAdapter(getContext(), R.layout.listactivity_items, activityList);
        listActivity.setAdapter(myAdapter);

        return view;
    }
}