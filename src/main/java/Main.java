import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static Student[] students = new Student[100];

    static Student[] compSciStudents = new Student[100];
    static Student[] apMathStudents = new Student[100];
    static Student[] statStudents = new Student[100];

    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("student-master-list.csv"))) {
            String line = "";
            bufferedReader.readLine();
            int index = 0;
            while((line = bufferedReader.readLine()) != null){
                String[] studentInfo = line.split(",");
                students[index++] = (new Student(Integer.parseInt(studentInfo[0]),studentInfo[1],studentInfo[2],Integer.parseInt(studentInfo[3])));
            }

            Arrays.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Student student1, Student student2) {
                    return student2.getGrade().compareTo(student1.getGrade());
                }
            });

            int compSciIndex = 0;
            int apMathIndex = 0;
            int statIndex = 0;

            for (Student student : students) {

                if(student.getCourse().contains("COMPSCI")){
                    compSciStudents[compSciIndex++] = student;
                } else if(student.getCourse().contains("APMTH")){
                    apMathStudents[apMathIndex++] = student;
                } else if(student.getCourse().contains("STAT")){
                    statStudents[statIndex++] = student;
                } else{
                    System.out.println("Student class was not found");
                }

            }

            printToCSV("course1", compSciStudents);
            printToCSV("course2", apMathStudents);
            printToCSV("course3", statStudents);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void printToCSV(String fileName,Student[] studentsInClass) throws IOException {
        FileWriter fileWrt = new FileWriter(fileName + ".csv");

        BufferedWriter bufferWrt = new BufferedWriter(fileWrt);

        bufferWrt.write("Student ID,Student Name,Course,Grade\n");
        for (Student student: studentsInClass) {
            if(student != null){
                bufferWrt.write( student.getStudentId() + "," + student.getStudentName() + "," + student.getCourse() + "," + student.getGrade() + "\n");
            }
        }

        bufferWrt.close();
    }
}
