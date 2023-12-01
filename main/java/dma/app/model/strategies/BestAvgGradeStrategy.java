package dma.app.model.strategies;

import java.util.List;

import dma.app.model.Application;
import dma.app.model.Student;

public class BestAvgGradeStrategy extends TemplateStrategyAlgorithm {
	
	
	public BestAvgGradeStrategy() {
		
	}
	
	@Override
	public Student findApplicant(List<Application> app) {
		double bestGrade = 0.0;
		Student student = app.get(0).getStudent();
		
		for( int i = 0; i < app.size(); i++) {
			if( app.get(i).getStudent().getCurrentAverageGrade() > bestGrade) {
				bestGrade = app.get(i).getStudent().getCurrentAverageGrade();
				student = app.get(i).getStudent();
			}
		}
		return student;	
	}

}
