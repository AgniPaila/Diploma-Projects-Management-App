package dma.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dma.app.dao.ProfessorDAO;
import dma.app.dao.SubjectDAO;
import dma.app.model.Professor;
import dma.app.model.Student;
import dma.app.model.Subject;
import dma.app.model.Thesis;
import dma.app.model.strategies.BestApplicantStrategy;
import dma.app.model.strategies.BestApplicantStrategyFactory;

@Service
public class ProfessorServiceImpl implements ProfessorService{
	
	@Autowired
	private ProfessorDAO professorRepository;
		
	@Autowired
	private SubjectDAO subjectDAO;
	
	@Autowired
	private ThesisService thesisService;
	
	
	private BestApplicantStrategyFactory strategyFactory = new BestApplicantStrategyFactory();
	
	
	@Autowired
	public ProfessorServiceImpl(ProfessorDAO theProfessorRepository) {
		professorRepository = theProfessorRepository;
	}
	
	public ProfessorServiceImpl() {
		
	}
	
	@Override
	@Transactional
	public void saveProfile(Professor professor) {
		professorRepository.save(professor);
		
	}
	
	@Override
	@Transactional
	public Professor findByUserId(int theId) {
		Professor result = professorRepository.findByUserId(theId);		
		return result;
	}
	
	
	
	@Override
	@Transactional
	public void assignSubject(String strategy, Integer subid, double th1, int th2) {
		Subject currentSubject = subjectDAO.findById(subid).get();
		currentSubject.setAvailable(false);
		BestApplicantStrategy str = strategyFactory.createStrategy(strategy, th1, th2);
		
		Student stud = str.findBestApplicant(currentSubject.getApplications());
		
		Thesis thesis = new Thesis();
    	thesis.setSubject(currentSubject); 
    	thesis.setStudent(stud);
    	thesis.setSupervisorProfessor(currentSubject.getSupervisorProfessor());
    	thesisService.save(thesis);
    	
	}
	


}
