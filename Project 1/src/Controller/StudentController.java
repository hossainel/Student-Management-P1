package Controller;

import Models.*;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    private final Scanner sc = new Scanner(System.in);
    private final StudentModel studentModel = new StudentModel();
    private final AdviseModel advisedModel = new AdviseModel();

    public void viewAllStudent(){
        List<Student> students = this.studentModel.getAllData();
        int index = 0;
        for (Student student : students){
            index++;
            System.out.println(index + ". " + student);
        }
    }
    public void searchStudent() {
        System.out.print("Search Student by ID: ");
        Student student = studentModel.getUserData(this.sc.next());
        if (student == null){
            System.out.println("Student Not Found!");
        } else {
            System.out.println(student);
        }
    }
    public void addStudent(){
        System.out.println("Add New Student:");
        System.out.print(" - Student ID: ");
        String ID = this.sc.nextLine();
        Student student = studentModel.getUserData(ID);
        if (student != null && !ID.isEmpty()){
            System.out.println("Student Exists!");
            System.out.println(student);
        } else {
            System.out.print(" - Student Name: ");
            String name = this.sc.nextLine();
            System.out.print(" - Program Name: ");
            String program = this.sc.nextLine();
            System.out.print(" - Batch: ");
            String batch = this.sc.nextLine();
            System.out.print(" - CGPA: ");
            String CGPA = this.sc.nextLine();
            System.out.print(" - Password: ");
            String password = this.sc.nextLine();
            student = new Student(name, ID, program, batch, CGPA, password);
            studentModel.addStudent(student);
            System.out.println(student);
        }
    }
    public void advisedCourse() {
        CourseController courseController = new CourseController();
        System.out.print(" - Enter Student ID to assign Course: ");
        String ID = this.sc.nextLine();
        Student student = studentModel.getUserData(ID);
        if (student != null){
            boolean addMore = true;
            System.out.println("Add course for student: ");
            System.out.println(student);
            while (addMore) {
                System.out.print(" - Courses available for student: ");
                courseController.viewAllCourseCode();
                System.out.print("\n - Add Course by Code: ");
                String code = this.sc.nextLine();
                advisedModel.addAdvisedCourse(new Advise(ID, code));
                System.out.print("Add More [y/N]: ");
                addMore = sc.nextLine().equalsIgnoreCase("y");
            }
            System.out.println(studentModel.getUserData(ID));
        } else {
            System.out.println("Student Not Found!");
        }
    }

}
