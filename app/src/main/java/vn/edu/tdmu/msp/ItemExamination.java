package vn.edu.tdmu.msp;

public class ItemExamination {
    String dayOfWeek, time, date, subject, room, timeUp;

    public ItemExamination(String dayOfWeek, String time, String date, String subject, String room, String timeUp) {
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.date = date;
        this.subject = subject;
        this.room = room;
        this.timeUp = timeUp;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTimeUp() {
        return timeUp;
    }

    public void setTimeUp(String timeUp) {
        this.timeUp = timeUp;
    }
}
