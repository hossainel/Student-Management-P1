package Models;

import Database.FileManager;

import java.util.ArrayList;
import java.util.List;

public class CourseModel {
    private final FileManager fileManager = new FileManager("course");

    public List<Course> getAllData() {
        List<Course> courses = new ArrayList<>();
        for(String data : this.fileManager.getData()) {
            courses.add(new Course(this.fileManager.s2l(data)));
        }
        return courses;
    }

    //For course Search
    public Course getCourseName(String courseCode) {
        List<String> data = this.fileManager.getData();
        Course course;
        for(String cor: data) {
            course = new Course(this.fileManager.s2l(cor));
            if( courseCode.equals(course.getCode()) ) {
                return course;
            }
        }
        return null;
    }
    public void addCourse(Course course) {
        this.fileManager.addData(course.getCourses());
        System.out.println("Course Added");
    }
}
