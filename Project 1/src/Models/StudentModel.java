package Models;

import Database.FileManager;

import java.util.ArrayList;
import java.util.List;

public class StudentModel {
    private final FileManager fileManager = new FileManager("student");

    public List<Student> getAllData() {
        List<Student> students = new ArrayList<>();
        for(String data : this.fileManager.getData()) {
            students.add(new Student(this.fileManager.s2l(data)));
        }
        return students;
    }

    //For Searching by ID
    public Student getUserData(String ID) {
        List<String> data = this.fileManager.getData();
        Student student;
        for(String stu: data) {
            student = new Student(this.fileManager.s2l(stu));
            if( ID.equals(student.getID()) ) {
                return student;
            }
        }
        return null;
    }
    public void addStudent(Student student) {
        this.fileManager.addData(student.getStudents());
        System.out.println("Student Added");
    }
}
