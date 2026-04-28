package Models;

import Database.FileManager;

import java.util.ArrayList;
import java.util.List;

public class AdviseModel {
    private final FileManager fileManager = new FileManager("advise");

    public List<Advise> getAllData() {
        List<Advise> advises = new ArrayList<>();
        for(String data : this.fileManager.getData()) {
            advises.add(new Advise(this.fileManager.s2l(data)));
        }
        return advises;
    }

    //For ID by course Search
    public List<Advise> getCourseByID(String ID) {
        List<String> data = this.fileManager.getData();
        List<Advise> advises = new ArrayList<>();
        Advise advise;
        for(String adv: data) {
            advise = new Advise(this.fileManager.s2l(adv));
            if( ID.equals(advise.getID()) ) {
                advises.add(advise);
            }
        }
        return advises;
    }
    public void addAdvisedCourse(Advise advise) {
        this.fileManager.addData(advise.getAdvisedCourses());
        System.out.println("Course Added.");
    }
}
