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

public class ExaminationFragment extends Fragment {

    ListView listExamination;
    List<ItemExamination> examinationList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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