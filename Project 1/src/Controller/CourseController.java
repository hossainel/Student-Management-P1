package Controller;

import Models.Course;
import Models.CourseModel;

import java.util.List;
import java.util.Scanner;

public class CourseController {
    private final Scanner sc = new Scanner(System.in);
    private final CourseModel courseModel = new CourseModel();

    public void viewAllCourse(){
        List<Course> courses = this.courseModel.getAllData();
        int index = 0;
        for (Course course : courses){
            index++;
            System.out.println(index + ". " + course);
        }
    }

    public void viewAllCourseCode(){
        List<Course> courses = this.courseModel.getAllData();
        for (Course course : courses){
            System.out.print(course.getCode()+ ", ");
        }
    }
    public void searchCourse(){
        System.out.print("Search Course by code: ");
        Course course = courseModel.getCourseName(this.sc.next());
        if (course == null){
            System.out.println("Invalid Course Name");
        } else {
            System.out.println(course);
        }
    }
    public void addCourse(){
        System.out.println("Add New Course:");
        System.out.print(" - Course Code: ");
        String courseCode = this.sc.nextLine();
        Course course = courseModel.getCourseName(courseCode);
        if (course != null && !courseCode.isEmpty()){
            System.out.println("Course Exists!");
            System.out.println(course);
        } else {
            System.out.print(" - Course Name: ");
            String courseName = this.sc.nextLine();
            course = new Course(courseCode, courseName);
            courseModel.addCourse(course);
            System.out.println(course);
        }
    }

}
