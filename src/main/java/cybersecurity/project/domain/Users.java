/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cybersecurity.project.domain;

import java.util.ArrayList;

public class Users {
    private ArrayList<User> users;
    
    public Users() {
        this.users = new ArrayList<>();
        
        this.users.add(new User("User1", "salasana1"));
        this.users.add(new User("User2", "salasana2"));
        this.users.add(new User("User3", "salasana3"));
    }
    
    public void addUser(User user) {
        this.users.add(user);
    }
    
    public ArrayList<User> getUsers() {
        return this.users;
    }
}
