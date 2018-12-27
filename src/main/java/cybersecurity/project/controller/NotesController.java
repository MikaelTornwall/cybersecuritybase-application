/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cybersecurity.project.controller;

import cybersecurity.project.domain.Note;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotesController {
    ArrayList<Note> notes;
    
    public NotesController() {
        this.notes = new ArrayList<>();
        
        this.notes.add(new Note("Note1"));
        this.notes.add(new Note("Note2"));
        this.notes.add(new Note("Note3"));        
    }
    
    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String loadNotes(Model model) {
        model.addAttribute("notes", this.notes);
        
        return "notes";
    }
}
