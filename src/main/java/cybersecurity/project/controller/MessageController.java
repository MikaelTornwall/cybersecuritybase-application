/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cybersecurity.project.controller;

import cybersecurity.project.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import cybersecurity.project.repository.MessageRepository;

@Controller
public class MessageController {
    private ArrayList<Message> messages;
    
    @Autowired
    private MessageRepository messageRepository;
    
    public MessageController() {
        this.messages = new ArrayList<>();           
    }
    
    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public String loadMessages(Model model) {        
        model.addAttribute("messages", messageRepository.findAll());
        
        return "messages";
    }
    
    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public String addMessage(@RequestParam String message) {
        
        if (!message.trim().isEmpty()) {
            messageRepository.save(new Message(message));
        }        
        
        return "redirect:/messages";
    }
}
