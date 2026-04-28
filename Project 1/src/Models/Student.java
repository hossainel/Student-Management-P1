package Models;

import java.util.ArrayList;
import java.util.List;
import static java.lang.String.join;

public class Student {
    private String name;
    private String ID;
    private String program;
    private String batch;
    private String CGPA;
    private String password;

    private Advise advise;
    private AdviseModel adviseModel = new AdviseModel();
    private String advisedCourse = null;

    public Student(String name, String ID, String program, String batch, String CGPA, String password){
        this.name = name;
        this.ID = ID;
        this.program = program;
        this.batch = batch;
        this.CGPA = CGPA;
        this.password = password;
        setAdvisedCourse(this.adviseModel.getCourseByID(ID));
    }

    Student (List<String> student){
        this.name = student.get(0);
        this.ID = student.get(1);
        this.program = student.get(2);
        this.batch = student.get(3);
        this.CGPA = student.get(4);
        this.password = student.get(5);
        setAdvisedCourse(this.adviseModel.getCourseByID(this.ID));
    }

    public String getName() { return this.name; }
    public String getID() { return this.ID; }
    public String getProgram() { return this.program; }
    public String getBatch() { return this.batch; }
    public String getCGPA() { return this.CGPA; }
    public boolean checkPassword(String password) { return password.equals(this.password); }
    public String getAdvisedCourse() { return this.advisedCourse; }

    public List<String> getStudents(){
        List<String> list = new ArrayList<>();
        list.add(this.name);
        list.add(this.ID);
        list.add(this.program);
        list.add(this.batch);
        list.add(this.CGPA);
        list.add(this.password);
        return list;
    }
    public void setAdvisedCourse(List<Advise> advisedCourse) {
        this.advisedCourse = join(",",advisedCourse.toString());
    }
    public void setAdvisedCourse(String advisedCourse) {
        this.advisedCourse = advisedCourse;
    }
    @Override
    public String toString() {
        String studentString =  "Student Name: " + this.name + " | ID: " + this.ID +
             "\n Program: " + this.program + " | batch: " + this.batch +
             " | CGPA: " + this.CGPA + "\n Advised Course: ";
        if (this.advisedCourse==null||this.advisedCourse.isEmpty()){
            studentString += "No Courses Assigned.";
        } else {
            studentString += this.advisedCourse;
        } return studentString;
    }

}