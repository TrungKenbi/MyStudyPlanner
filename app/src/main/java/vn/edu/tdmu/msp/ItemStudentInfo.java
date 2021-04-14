package vn.edu.tdmu.msp;

public class ItemStudentInfo {
    String name, code, gender, dayOfBirth, placeOfBirth, studentClass, major, faculty;

    public ItemStudentInfo(String name, String code, String gender, String dayOfBirth, String placeOfBirth, String studentClass, String major, String faculty) {
        this.name = name;
        this.code = code;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.studentClass = studentClass;
        this.major = major;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
