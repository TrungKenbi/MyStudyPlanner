package vn.edu.tdmu.msp;

public class ItemStudentMark {
    String subjectCode, subjectName, middleMark, finalMark, status, averageMark;

    public ItemStudentMark(String subjectCode, String subjectName, String middleMark, String finalMark, String status, String averageMark) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.middleMark = middleMark;
        this.finalMark = finalMark;
        this.status = status;
        this.averageMark = averageMark;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getMiddleMark() {
        return middleMark;
    }

    public void setMiddleMark(String middleMark) {
        this.middleMark = middleMark;
    }

    public String getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(String finalMark) {
        this.finalMark = finalMark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(String averageMark) {
        this.averageMark = averageMark;
    }
}
