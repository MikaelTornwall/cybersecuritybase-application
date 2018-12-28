package cybersecurity.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import cybersecurity.project.domain.User;
import cybersecurity.project.domain.Admin;
import cybersecurity.project.repository.UserRepository;
import cybersecurity.project.repository.AdminRepository;
import java.util.ArrayList;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private ArrayList<User> userList;
    private ArrayList<Admin> adminList;    
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private AdminRepository adminRepository;
    
    public UserController() {                
        this.userList = new ArrayList<>(); 
        this.adminList = new ArrayList<>();         
    }     
        
    public void init() {
        userRepository.save(new User("User1", "password1"));
        adminRepository.save(new Admin("Admin", "password"));
    }
    
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String loadSignin(Model model) {                
        
        if (this.userList.isEmpty() && this.adminList.isEmpty()) {
            init();
        }
        
        model.addAttribute("notification", "Sign in below:");   
        
        return "signin";        
    }    
    
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model) {
        model.addAttribute("users", this.userList);
        
        return "dashboard";        
    }                
    
    @RequestMapping(value = "/signin", method = RequestMethod.POST)     
    public String submitForm(@RequestParam String name, @RequestParam String password, Model model) {                                  
        
        this.userRepository.findAll().stream().forEach(user -> this.userList.add(user));
        this.adminRepository.findAll().stream().forEach(admin -> this.adminList.add(admin));
        boolean foundUser = false;
        boolean foundAdmin = false;
        
        for (User user : this.userList) {
            if (user.getUsername().equals(name) && user.getPassword().equals(password)) {                
                foundUser = true;
            }
        }
        
        for (Admin admin : this.adminList) {
            if (admin.getAdmin().equals(name) && admin.getPassword().equals(password)) {
                foundAdmin = true;
            }
        }
        
        if (foundUser) {
            return "redirect:/messages";
        }
        
        if (foundAdmin) {
            return "redirect:/dashboard";
        }
               
        
        model.addAttribute("notification", "Invalid username or password. Try again.");        
        return "signin";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)    
    public String loadRegister() {
        return "register";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)    
    public String loadRegister(@RequestParam String username, @RequestParam String password) {
        System.out.println(username + password);                
        
        User user = new User(username, password);        
        this.userList.add(user);
        
        return "registered";
    }
}
