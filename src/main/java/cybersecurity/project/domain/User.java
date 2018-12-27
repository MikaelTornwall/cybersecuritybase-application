package cybersecurity.project.domain;

import java.util.ArrayList;
import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class User extends AbstractPersistable<Long> {
    private String username;
    private String password;    
    private ArrayList<String> notes;
    
    public User() {
        super();
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;       
        this.notes = new ArrayList<>();       
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }         
    
    public void addNote(String note) {
        this.notes.add(note);
    }
    
    public ArrayList<String> getNotes() {
        return this.notes;
    }
    
    public boolean validate(String password) {
        if (password == this.password) {
            return true;
        }
        
        return false;
    }
}
