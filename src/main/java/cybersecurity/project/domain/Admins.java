package cybersecurity.project.domain;

import java.util.ArrayList;

public class Admins {
    private ArrayList<User> admins;
    
    public Admins() {
        this.admins = new ArrayList<>();
        
        this.admins.add(new User("Admin", "salasana"));
    }
    
    public ArrayList<User> getAdmins() {
        return this.admins;
    }
}
