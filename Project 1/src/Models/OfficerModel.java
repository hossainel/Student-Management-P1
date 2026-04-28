package Models;

import Database.FileManager;

import java.util.ArrayList;
import java.util.List;

public class OfficerModel {
    private final FileManager fileManager = new FileManager("officer");

    public List<Officer> getAllData() {
        List<Officer> officers = new ArrayList<>();
        for(String data : this.fileManager.getData()) {
            officers.add(new Officer(this.fileManager.s2l(data)));
        }
        return officers;
    }

    //For login Checking
    public Officer getUserData(String username) {
        List<String> data = this.fileManager.getData();
        Officer officer;
        for(String off: data) {
            officer = new Officer(this.fileManager.s2l(off));
            if( username.equals(officer.getUsername()) ) {
                return officer;
            }
        }
        return null;
    }
}
