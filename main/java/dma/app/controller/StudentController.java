package dma.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dma.app.model.Application;
import dma.app.model.Student;
import dma.app.model.Subject;
import dma.app.model.User;
import dma.app.service.ApplicationService;
import dma.app.service.StudentService;
import dma.app.service.SubjectService;
import dma.app.service.UserService;

@Controller
public class StudentController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	public StudentController(StudentService theStudentService) {
		studentService = theStudentService;
	}
	
	
    @RequestMapping("/student/dashboard")
    public String getStudentHome(Model theModel){
    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 String currentPrincipalName = authentication.getName();
		 Optional<User> u = userService.findByUsername(currentPrincipalName);
		 User theUser = u.get();
		 theModel.addAttribute("user", theUser);
		 
		 Student theStudent = studentService.findByUserId(theUser.getId());
		 theModel.addAttribute("student", theStudent);
		 
		
        return "student/dashboard";
    }
    
    
    
    @RequestMapping("/student/save")
    public String showDashboard(@ModelAttribute("student") Student thestudent){

        studentService.saveProfile(thestudent);
        
        return "student/dashboard";
    }
    
    
    @RequestMapping("/student/profile")
    public String saveStudent(@ModelAttribute("student") Student thestudent,Model theModel) {

    	Student theStudent = studentService.findByUserId(getUser().getId());
        theModel.addAttribute("student",theStudent);
        
        return "student/profile";
    }
    
    

    public User getUser(){
    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 String currentPrincipalName = authentication.getName();
		 Optional<User> u = userService.findByUsername(currentPrincipalName);
		 User theUser = u.get();
        return theUser;
    }
    
    @RequestMapping("/student/listofavailablesubjects")
	public String listAvailableSubjects(@ModelAttribute("subject") Subject thesubject, Model theModel) {
		
    	List<Subject> theAvailableSubjects = new ArrayList<Subject>();
    	 	
    	List<Subject> allSubjects = subjectService.findAll();
    	for(int i=0; i<allSubjects.size(); i++ ) {
    		if(allSubjects.get(i).getAvailable()==true) {
    			
    			theAvailableSubjects.add(allSubjects.get(i));
    		}
    	}
		theModel.addAttribute("subject", theAvailableSubjects);
		
		return "student/availablesubjects";
	}
    
    
    @RequestMapping("/student/listofavailablesubjects/details")
	public String showDetails(@RequestParam("subjectId") int theId, Model theModel) {

    	Subject theSubject = subjectService.findById(theId);

		theModel.addAttribute("subject", theSubject);
		
		return "student/subjectdetails";			
	}
    
    
    public Student getStudent() {
		Student stud = studentService.findByUserId(getUser().getId());

		return stud;
	}
    
    
    @RequestMapping("/student/application")
	public String applyForSubject(@RequestParam("subjectId") int theId, Model theModel) {
    	
    	Student student = getStudent();
    	List<Application> applications = student.getApplications();  
    	
    	for (int i = 0; i < applications.size(); i++) {
    		
    		if ( applications.get(i).getSubject().getId() == theId ) {
    			
    			return "student/alreadyapplied";
    		}
    	}
    	
    	Application app = new Application();
    	app.setSubject(subjectService.findById(theId));
    	app.setStudent(getStudent());
    	
    	applicationService.save(app);

		return "student/successfulapply";			
	}
    
    
}
