package vn.edu.tdmu.msp;

public class ItemSubjectTimetable {
    String time, subjectName, room;

    public ItemSubjectTimetable(String time, String subjectName, String room) {
        this.time = time;
        this.subjectName = subjectName;
        this.room = room;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
