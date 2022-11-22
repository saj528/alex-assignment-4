import java.util.Comparator;

public class Student {
    Integer studentId;
    String studentName;
    String course;
    Integer grade;

    public Student(int studentId, String studentName, String course, int grade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        this.grade = grade;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
