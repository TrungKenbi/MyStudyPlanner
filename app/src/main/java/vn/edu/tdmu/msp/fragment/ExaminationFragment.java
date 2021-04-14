package vn.edu.tdmu.msp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.tdmu.msp.ItemExamination;
import vn.edu.tdmu.msp.R;
import vn.edu.tdmu.msp.adapter.ExaminationAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExaminationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExaminationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExaminationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotificationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExaminationFragment newInstance(String param1, String param2) {
        ExaminationFragment fragment = new ExaminationFragment();
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

    ListView listExamination;
    List<ItemExamination> examinationList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_examination, container, false);

        listExamination = view.findViewById(R.id.listExamination);
        examinationList = new ArrayList<>();
        examinationList.add(new ItemExamination("Thứ Ba", "14:25", "20/04/2021", "Toán cao cấp A1", "E3.104", "60 phút"));
        examinationList.add(new ItemExamination("Thứ Tư", "07:15", "28/04/2021", "Quản trị hệ thống", "C2.102", "60 phút"));
        ExaminationAdapter examinationAdapter = new ExaminationAdapter(getContext(), R.layout.list_examination_items, examinationList);
        listExamination.setAdapter(examinationAdapter);

        return view;
    }
}