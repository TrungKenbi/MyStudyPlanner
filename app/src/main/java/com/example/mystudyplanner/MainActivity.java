package com.example.mystudyplanner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listActivity;
    ArrayList<Item> acticityList = new ArrayList<Item>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listActivity = (ListView) findViewById(R.id.listActivity);
        acticityList.add(new Item("Nhập môn phát triển game", "Báo cáo cuối kỳ"));
        acticityList.add(new Item("Nhập môn phát triển game", "Báo cáo cuối kỳ"));
        acticityList.add(new Item("Nhập môn phát triển game", "Báo cáo cuối kỳ"));
        acticityList.add(new Item("Nhập môn phát triển game", "Báo cáo cuối kỳ"));
        acticityList.add(new Item("Nhập môn phát triển game", "Báo cáo cuối kỳ"));
        acticityList.add(new Item("Nhập môn phát triển game", "Báo cáo cuối kỳ"));

        MyAdapter myAdapter = new MyAdapter(this, R.layout.listactivity_items, acticityList);
        listActivity.setAdapter(myAdapter);
    }
}