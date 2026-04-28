package Models;

import java.util.ArrayList;
import java.util.List;

public class Advise {
    private String ID;
    private String courseCode;

    public Advise(String ID, String courseCode){
        this.ID = ID;
        this.courseCode = courseCode;
    }
    public Advise(List<String> advisedCourse){
        this.ID = advisedCourse.get(0);
        this.courseCode = advisedCourse.get(1);
    }

    public String getID() { return this.ID; }
    public String getCourseCode() { return this.courseCode; }
    public List<String> getAdvisedCourses(){
        List<String> list = new ArrayList<>();
        list.add(this.ID);
        list.add(this.courseCode);
        return list;
    }
    @Override
    public String toString() {
        return this.courseCode;
    }
}