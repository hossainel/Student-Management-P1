package Models;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String code;
    private String name;

    public Course(String code, String name){
        this.code = code;
        this.name = name;
    }
    public Course(List<String> courses){
        this.code = courses.get(0);
        this.name = courses.get(1);
    }

    public String getName() { return this.name; }
    public String getCode() { return this.code; }
    public List<String> getCourses(){
        List<String> list = new ArrayList<>();
        list.add(this.code);
        list.add(this.name);
        return list;
    }
    @Override
    public String toString() {
        return "Course Code: " + this.code + " | Name: " + this.name;
    }
}