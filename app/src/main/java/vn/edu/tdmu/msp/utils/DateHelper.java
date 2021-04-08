package vn.edu.tdmu.msp.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
    public static int getDayNumber() {
        int value;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            value = LocalDate.now().getDayOfWeek().getValue();
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            value = cal.get(Calendar.DAY_OF_WEEK) - 1;

        }

        if (value == 7)
            return 0;
        return value;
    }

    public static String getDayAsText(int dayNumber) {
        String text = "07:00";

        switch (dayNumber) {
            case 1:
                text = "07:00";
                break;
            case 2:
                text = "07:51";
                break;
            case 3:
                text = "09:00";
                break;
            case 4:
                text = "09:51";
                break;
            case 5:
                text = "10:41";
                break;
            case 6:
                text = "12:30";
                break;
            case 7:
                text = "13:21";
                break;
            case 8:
                text = "14:30";
                break;
            case 9:
                text = "15:21";
                break;
            case 10:
                text = "16:11";
                break;
            case 11:
                text = "17:30";
                break;
            case 12:
                text = "18:21";
                break;
            case 13:
                text = "19:30";
                break;
            case 14:
                text = "20:21";
                break;
        }
        return text;
    }
}
