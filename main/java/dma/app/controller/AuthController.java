package dma.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dma.app.model.Professor;
import dma.app.model.Role;
import dma.app.model.Student;
import dma.app.model.User;
import dma.app.service.StudentService;
import dma.app.service.SubjectService;
import dma.app.service.UserService;
import dma.app.service.ProfessorService;

@Controller
public class AuthController {
    @Autowired
    UserService userService;
    
    @Autowired
    StudentService studentService;
    
    @Autowired
    ProfessorService professorService;

    @Autowired
    SubjectService subjectService;

    @RequestMapping("/login")
    public String login(){
        return "auth/signin";
    }

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "auth/signup";
    }

    @RequestMapping("/save")
    public String registerUser(@ModelAttribute("user") User user, Model model){
       
        if(userService.isUserPresent(user)){
            model.addAttribute("successMessage", "User already registered!");
            return "auth/signin";
        }
        if(user.getRole().equals(Role.STUDENT)) {
        	Student st = new Student(user);
        	studentService.saveProfile(st);	
        }
        if(user.getRole().equals(Role.PROFESSOR)) {
        	Professor prof = new Professor(user);
        	professorService.saveProfile(prof);	
        }
        
        userService.saveUser(user);
        model.addAttribute("successMessage", "User registered successfully!");

        return "auth/signin";
    }
}
