package vn.edu.tdmu.msp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.tdmu.msp.ItemActivityHome;
import vn.edu.tdmu.msp.ItemSubjectTimetable;
import vn.edu.tdmu.msp.R;
import vn.edu.tdmu.msp.adapter.MyAdapter;
import vn.edu.tdmu.msp.adapter.MySubjectTimetableAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimetableFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimetableFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TimetableFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TimetableFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TimetableFragment newInstance(String param1, String param2) {
        TimetableFragment fragment = new TimetableFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ListView listSubjectTimetable;
    List<ItemSubjectTimetable> subjectTimetableList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_timetable, container, false);

        listSubjectTimetable = view.findViewById(R.id.listSubjectTimetable);
        subjectTimetableList = new ArrayList<>();
        subjectTimetableList.add(new ItemSubjectTimetable("12:30", "Nhập môn phát triển game (2+1)", "I4.207"));
        subjectTimetableList.add(new ItemSubjectTimetable("12:31", "Nhập môn phát triển game 2 (2+1)", "I4.207"));
        subjectTimetableList.add(new ItemSubjectTimetable("12:32", "Nhập môn phát triển game 3 (2+1)", "I4.207"));
        subjectTimetableList.add(new ItemSubjectTimetable("12:33", "Nhập môn phát triển game 4 (2+1)", "I4.207"));
        subjectTimetableList.add(new ItemSubjectTimetable("12:34", "Nhập môn phát triển game 5 (2+1)", "I4.207"));
        subjectTimetableList.add(new ItemSubjectTimetable("12:35", "Nhập môn phát triển game 6 (2+1)", "I4.207"));

        MySubjectTimetableAdapter mySubjectTimetableAdapter = new MySubjectTimetableAdapter(getContext(), R.layout.list_subject_timetable_items, subjectTimetableList);
        listSubjectTimetable.setAdapter(mySubjectTimetableAdapter);

        return view;
    }
}