package cybersecurity.project.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Admin extends AbstractPersistable<Long> {
    private String username;
    private String password;
    
    public Admin() {
        super();
    }
    
    public Admin(String name, String password) {
        this.username = name;
        this.password = password;
    }
    
    public String getAdmin() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
}
