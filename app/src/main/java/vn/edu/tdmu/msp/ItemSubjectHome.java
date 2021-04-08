package vn.edu.tdmu.msp;

public class ItemSubjectHome {
    String moment, time, subjectName, room;

    public ItemSubjectHome(String moment, String time, String subjectName, String room) {
        this.moment = moment;
        this.time = time;
        this.subjectName = subjectName;
        this.room = room;
    }

    public String getMoment() {
        return moment;
    }

    public void setMoment(String moment) {
        this.moment = moment;
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
