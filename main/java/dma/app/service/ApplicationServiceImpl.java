package dma.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dma.app.dao.ApplicationDAO;
import dma.app.model.Application;


@Service
public class ApplicationServiceImpl implements ApplicationService {
	
	@Autowired
	private ApplicationDAO applicationRepository;
	
	@Autowired
	public ApplicationServiceImpl(ApplicationDAO theApplicationRepository) {
		applicationRepository = theApplicationRepository;
	}
	
	public ApplicationServiceImpl() {
		
	}
	
	@Override
	@Transactional
	public Application findById(int theId) {
		Application result = applicationRepository.findById(theId);
				
		return result;
	}

	@Override
	@Transactional
	public void save(Application app) {
		applicationRepository.save(app);
		
	}

	@Override
	public Application findBySubjectId(int theId) {
		Application result = applicationRepository.findBySubjectId(theId);
		
		return result;
	}

}
