package Models;

import java.util.List;

public class Officer {
    private String name;
    private String username;
    private String password;

    Officer(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }
    Officer (List<String> officer){
        this.name = officer.get(0);
        this.username = officer.get(1);
        this.password = officer.get(2);
    }

    public String getName() { return this.name; }
    public String getUsername() { return this.username; }
    public boolean checkPassword(String password) { return password.equals(this.password); }
}