package dma.app.model.strategies;

import java.util.ArrayList;
import java.util.List;

import dma.app.model.Application;
import dma.app.model.Student;

public class ThresholdStrategy extends TemplateStrategyAlgorithm {
	
	private double th1;
	private double th2;
	
	
	public ThresholdStrategy(){
		
	}
	
	public ThresholdStrategy(double th1, int th2){
		this.th1 = th1;
		this.th2 = th2;
	}
	
	
	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	

	@Override
	public Student findApplicant(List<Application> app) {
		
		List<Student> candidateStudents = new ArrayList<Student>();
		

		for (int i = 0; i < app.size(); i++) {
			Student currentStudent = app.get(i).getStudent();
			if (currentStudent.getCurrentAverageGrade() > th1  && currentStudent.getRemainingCourses() < th2) {
				candidateStudents.add(currentStudent);
			}
		}
		
		
		if (candidateStudents.size() == 1 ) {
			return candidateStudents.get(0);
		}
		else if (candidateStudents.size() > 1 ) {
			int randomNumber = getRandomNumber(0,candidateStudents.size());
			return candidateStudents.get(randomNumber);
		}
		else {
			int randomNumber = getRandomNumber(0,app.size());
			return app.get(randomNumber).getStudent();	
		}
	}
	
}
