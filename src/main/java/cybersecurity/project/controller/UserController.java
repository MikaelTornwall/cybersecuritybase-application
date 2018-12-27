package cybersecurity.project.controller;

import org.springframework.stereotype.Controller;
import cybersecurity.project.domain.User;
import cybersecurity.project.domain.Users;
import cybersecurity.project.domain.Admins;
import java.util.ArrayList;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private ArrayList<User> userList;
    private ArrayList<User> adminList;
    private Users users;
    private Admins admins;
    
    public UserController() {
        this.userList = new ArrayList<>();  
        this.adminList = new ArrayList<>();
        this.users = new Users();
        this.admins= new Admins();
        
        this.users.getUsers().stream().forEach(user -> userList.add(user));
        this.admins.getAdmins().stream().forEach(admin -> adminList.add(admin));
    }     
    
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String loadSignin(Model model) {
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
        System.out.println("LÄPI MENEE");     
        System.out.println(name + password);
        
        boolean foundUser = false;
        boolean foundAdmin = false;
        
        for (User user : this.userList) {
            if (user.getUsername().equals(name) && user.getPassword().equals(password)) {                
                foundUser = true;
            }
        }
        
        for (User admin : this.adminList) {
            if (admin.getUsername().equals(name) && admin.getPassword().equals(password)) {
                foundAdmin = true;
            }
        }
        
        if (foundUser) {
            return "redirect:/notes";
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
        this.users.addUser(user);
        this.userList.add(user);
        
        return "registered";
    }
}
