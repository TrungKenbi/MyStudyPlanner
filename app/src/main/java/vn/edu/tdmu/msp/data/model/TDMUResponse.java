package vn.edu.tdmu.msp.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TDMUResponse {

    @SerializedName("studentInfo")
    @Expose
    private StudentInfo studentInfo;
    @SerializedName("timetable")
    @Expose
    private List<Subject> timetable = null;

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public List<Subject> getTimetable() {
        return timetable;
    }

    public void setTimetable(List<Subject> timetable) {
        this.timetable = timetable;
    }
}
