package dma.app.service;

import org.springframework.stereotype.Service;


import dma.app.model.Thesis;

@Service
public interface ThesisService {
	
	public void save(Thesis thesis);
	public Thesis findById(int theId);
	public double calculateGrade(double implGrade, double repGrade, double presGrade);
}
