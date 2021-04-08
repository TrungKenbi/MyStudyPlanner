package vn.edu.tdmu.msp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subject {
    @SerializedName("subjectName")
    @Expose
    private String subjectName;
    @SerializedName("SubjectCode")
    @Expose
    private String subjectCode;
    @SerializedName("dayOfWeekVi")
    @Expose
    private String dayOfWeekVi;
    @SerializedName("dayOfWeek")
    @Expose
    private Integer dayOfWeek;
    @SerializedName("roomName")
    @Expose
    private String roomName;
    @SerializedName("teacherName")
    @Expose
    private String teacherName;
    @SerializedName("timeStart")
    @Expose
    private Integer timeStart;
    @SerializedName("timeStop")
    @Expose
    private Integer timeStop;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getDayOfWeekVi() {
        return dayOfWeekVi;
    }

    public void setDayOfWeekVi(String dayOfWeekVi) {
        this.dayOfWeekVi = dayOfWeekVi;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Integer timeStart) {
        this.timeStart = timeStart;
    }

    public Integer getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(Integer timeStop) {
        this.timeStop = timeStop;
    }

}
