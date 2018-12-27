package cybersecurity.project.controller;

import org.springframework.stereotype.Controller;
import cybersecurity.project.domain.User;
import java.util.ArrayList;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignInController {
    private ArrayList<User> users;
    
    public SignInController() {
        this.users = new ArrayList<>();
        
        this.users.add(new User("User1", "salasana1"));
        this.users.add(new User("User2", "salasana2"));
        this.users.add(new User("User3", "salasana3"));
    }     
    
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String loadSignin(Model model) {
        model.addAttribute("notification", "Sign in below");
        return "signin";        
    }
    
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model) {
        model.addAttribute("users", this.users);
        
        return "dashboard";        
    }            
    
    @RequestMapping(value = "/signin", method = RequestMethod.POST)   
    public String submitForm() {        
        System.out.println("LÄPI MENEE");        
        
        return "redirect:/signin";
    }
}
