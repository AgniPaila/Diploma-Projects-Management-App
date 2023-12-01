package dma.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import dma.app.dao.SubjectDAO;
import dma.app.model.Subject;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectDAO subjectRepository;
	
	@Autowired
	public SubjectServiceImpl(SubjectDAO theSubjectRepository) {
		subjectRepository = theSubjectRepository;
	}
	
	public SubjectServiceImpl() {
	
	}
	
	@Override
	@Transactional
	public List<Subject> findAll() {
		return subjectRepository.findAll();
	}

	@Override
	@Transactional
	public Subject findById(int theId) {
		Subject result = subjectRepository.findById(theId);
				
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the student
			throw new RuntimeException("Did not find subject id - " + theId);
		}
	}

	@Override
	@Transactional
	public void save(Subject subject) {
		subjectRepository.save(subject);
	}


	
	@Override
	@Transactional
	public void deleteById(int theId) {
		subjectRepository.deleteById(theId);
	}

}
