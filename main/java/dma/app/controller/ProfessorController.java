package dma.app.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dma.app.model.Application;
import dma.app.model.Professor;
import dma.app.model.Subject;
import dma.app.model.Thesis;
import dma.app.model.User;
import dma.app.service.ProfessorService;
import dma.app.service.SubjectService;
import dma.app.service.ThesisService;
import dma.app.service.UserService;


@Controller
public class ProfessorController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private ThesisService thesisService;
	
	private int sid;
	
	
	@Autowired
	public ProfessorController(ProfessorService theProfessorService) {
		professorService = theProfessorService;
	}

    @RequestMapping("/professor/dashboard")
    public String getProfessorHome(Model theModel){
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Optional<User> u = userService.findByUsername(currentPrincipalName);
		User theUser = u.get();
		theModel.addAttribute("user", theUser);
		
		Professor theProfessor = professorService.findByUserId(theUser.getId());
		theModel.addAttribute("professor", theProfessor);


		return "professor/dashboard";
    }
    
    @RequestMapping("/professor/save")
    public String showDashboard(@ModelAttribute("professor") Professor theprofessor){

        professorService.saveProfile(theprofessor);
        
        return "professor/dashboard";
    }
    
    
    @RequestMapping("/professor/profile")
    public String saveProfessor(@ModelAttribute("professor") Professor theprofessor,Model theModel) {
    	Professor theProfessor = professorService.findByUserId(getUser2().getId());
        theModel.addAttribute("professor",theProfessor);
        
        return "professor/profile";
    }
    
    

    public User getUser2(){
    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 String currentPrincipalName = authentication.getName();
		 Optional<User> u = userService.findByUsername(currentPrincipalName);
		 User theUser = u.get();
        return theUser;
    }
    
    
    public Professor getProfessor() {
		Professor prof = professorService.findByUserId(getUser2().getId());

		return prof;
	}
    
    @RequestMapping("/professor/subjects")
    public String showSubject(Model theModel) {
    	Professor theProfessor = professorService.findByUserId(getUser2().getId());
        theModel.addAttribute("professor",theProfessor);
        
        List<Subject> theSubjects = theProfessor.getSubjects();
        theModel.addAttribute("subjects", theSubjects);
        
        return "professor/subjects";
    }
    
    
    @RequestMapping("/professor/showFormForAdd")
	public String showFormForAdd(@ModelAttribute("subject") Subject thesubject,Model theModel) {    	
		
    	Subject s = new Subject();
    	s.setSupervisorProfessor(getProfessor());
		theModel.addAttribute("subject", s);
		
		return "professor/addsubject";
	}
    
    @RequestMapping("/professor/showFormForAdd/save")
    public String saveSubject(@ModelAttribute("subject") Subject thesubject){

        thesubject.setSupervisorProfessor(getProfessor());
    	subjectService.save(thesubject);
        
        return "redirect:/professor/subjects";
    }
    
    
    @RequestMapping("/professor/subjects/delete")
    public String deleteSubject(@RequestParam("subjectId") int theId) {

    	List<Application> list = subjectService.findById(theId).getApplications();
    	if(list.size() > 0) {
    		return "/professor/denydeletion";
    	}
    	
    	subjectService.deleteById(theId);
		
		return "redirect:/professor/subjects";
    }
    
    
    @RequestMapping("/professor/subjects/update")
	public String showFormForUpdate(@RequestParam("subjectId") int theId, Model theModel) {

    	Subject theSubject = subjectService.findById(theId);

		theModel.addAttribute("subject", theSubject);
		
		return "professor/addsubject";			
	}
    
    
    
    
    @RequestMapping("/professor/subjects/applications")
    public String showApplications(@RequestParam("subjectId") int theId, Model theModel) {
    	sid = theId;
    	Subject theSubject = subjectService.findById(theId);
    	
    	List<Application> theApplications = theSubject.getApplications();
    	
    	theModel.addAttribute("applications",theApplications);
    	return "professor/applications";
    	
    }
    
    
    @RequestMapping("/professor/assign")
    public String assignSubject(@RequestParam(name = "button1", required = false) String button1  , @RequestParam(name = "button2", required = false ) String button2,
    			@RequestParam(name = "button3", required = false) String button3, @RequestParam(name = "button4", required = false) String button4 ) {
    	
    	List<Application> applications = subjectService.findById(sid).getApplications();
    	if (applications.size() == 0 && (button1 != null || button2 != null || button3 != null || button4 != null)) {
    		return "professor/denyassignment";
    	}
    	
    	if (button1 != null) {
    		professorService.assignSubject("RandomChoice", sid, 0.0, 0);
    	}
    	else if (button2 != null) {
    		professorService.assignSubject("BestAvgGrade", sid, 0.0, 0);
    	}
    	else if (button3 != null) {
			professorService.assignSubject("FewestCourses", sid, 0.0, 0);
    	}
		else if (button4 != null) {
    		return "professor/threshold";
    	}
    	
    	return "redirect:/professor/subjects";
    	
    }
    
    
    @PostMapping("/professor/threshold")
    public String assignSubjectWithThreshold(double th1, int th2, Model theModel) {

    	professorService.assignSubject("Threshold", sid, th1, th2);
    	
    	return "redirect:/professor/subjects";	
	}
    
    
    
    
    
    @RequestMapping("/professor/supervisions")
    public String showSupervisions(Model theModel) {
    	Professor theProfessor = professorService.findByUserId(getUser2().getId());
        theModel.addAttribute("professor",theProfessor);
    	
        List<Thesis> theThesis = theProfessor.getTheses();
        theModel.addAttribute("theses", theThesis);
        
        return "professor/thesisisupervise";
    }
    
    
    
    @RequestMapping("/professor/thesisGrades")
	public String setGrades(@RequestParam("thesisId") int theId, Model theModel) {
    	
    	Thesis theThesis = thesisService.findById(theId);
    	theModel.addAttribute("thesis", theThesis);
    	
		return "professor/grades";			
	}
    
    
    @RequestMapping("/professor/saveGrades")
    public String saveGrades(@ModelAttribute("thesis") Thesis thethesis){

    	thesisService.save(thethesis);
        
        return "redirect:/professor/supervisions";
    }
   
    
    
    @RequestMapping("/professor/calculateGrades")
	public String calculateTotalGrade(@RequestParam("thesisId") int theId, Model theModel) {

    	Thesis theThesis = thesisService.findById(theId);
    	
    	double implGrade = theThesis.getImplementationGrade();
    	double repGrade = theThesis.getReportGrade();
    	double presGrade = theThesis.getPresentationGrade();
    	
    	double totalGrade = thesisService.calculateGrade(implGrade, repGrade, presGrade);
    	
    	theThesis.setTotalGrade(totalGrade);
    	thesisService.save(theThesis);
    	
    	theModel.addAttribute("theses", theThesis);
    		
		return "professor/totalgrades";			
	}
}
