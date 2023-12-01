package dma.app.service;

import org.springframework.stereotype.Service;

import dma.app.model.Professor;


@Service
public interface ProfessorService {
	public void saveProfile(Professor professor);
	public Professor findByUserId(int theId);
	public void assignSubject(String s, Integer i, double th1, int th2);
	
}
