package dma.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dma.app.model.Subject;

@Service
public interface SubjectService {
	public Subject findById(int theId);
	public void save(Subject subject);
	public List<Subject> findAll();
	public void deleteById(int theId);
}
