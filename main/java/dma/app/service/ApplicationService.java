package dma.app.service;

import org.springframework.stereotype.Service;

import dma.app.model.Application;

@Service
public interface ApplicationService {
	public Application findById(int theId);
	public void save(Application app);
	public Application findBySubjectId(int theId);

}
