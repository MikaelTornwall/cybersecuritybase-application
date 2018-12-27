package cybersecurity.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class CyberSecurityBaseProjectApplication {       
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(CyberSecurityBaseProjectApplication.class, args);
    }
}
