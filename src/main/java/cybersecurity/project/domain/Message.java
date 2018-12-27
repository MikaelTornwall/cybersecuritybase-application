package cybersecurity.project.domain;

import java.util.Date;
import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Message extends AbstractPersistable<Long> {
    private String message;
    private String date;
    
    public Message() {
        super();
    }
    
    public Message(String message) {
        this.message = message;
        this.date = new Date().toString();
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
