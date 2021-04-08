package vn.edu.tdmu.msp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import vn.edu.tdmu.msp.fragment.HomeFragment;
import vn.edu.tdmu.msp.fragment.NotificationFragment;
import vn.edu.tdmu.msp.fragment.SettingFragment;
import vn.edu.tdmu.msp.fragment.TimetableFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm = getSupportFragmentManager();
        loadFragment(new HomeFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        fragment = new HomeFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.navigation_timetable:
                        fragment = new TimetableFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.navigation_notification:
                        fragment = new NotificationFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.navigation_setting:
                        fragment = new SettingFragment();
                        loadFragment(fragment);
                        return true;
                }
                return false;
            };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}