package vn.edu.tdmu.msp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import vn.edu.tdmu.msp.PopUpClass;
import vn.edu.tdmu.msp.LoginActivity;
import vn.edu.tdmu.msp.StudentInfo;
import vn.edu.tdmu.msp.R;
import vn.edu.tdmu.msp.StudentMarkActivity;

public class OtherFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_other, container, false);
        LinearLayout layoutInfo = (LinearLayout) v.findViewById(R.id.TaiKhoan);
        LinearLayout layoutMark = (LinearLayout) v.findViewById(R.id.XemDiem);
        LinearLayout layoutInfor = (LinearLayout) v.findViewById(R.id.ThongTin);
        LinearLayout layoutRules = (LinearLayout) v.findViewById(R.id.DieuKhoan);
        LinearLayout layoutLogOut = (LinearLayout) v.findViewById(R.id.DangXuat);

        layoutInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StudentInfo.class);
                startActivity(intent);
            }
        });

        layoutMark.setOnClickListener(v1 -> {
            Intent intent = new Intent(getActivity(), StudentMarkActivity.class);
            startActivity(intent);
        });

        layoutInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUpClass popUpClass = new PopUpClass();
                popUpClass.showPopupWindow(v);
            }
        });

        layoutRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUpClass popUpClass = new PopUpClass();
                popUpClass.showPopupWindowRules(v);
            }
        });

        layoutLogOut.setOnClickListener(v12 -> {
            if (!LoginActivity.IS_LOGIN)
                return;

            LoginActivity.IS_LOGIN = false;
            LoginActivity.USERNAME = "";
            LoginActivity.PASSWORD = "";
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });

        return v;
    }
}