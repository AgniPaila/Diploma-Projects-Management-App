package dma.app.model.strategies;

import java.util.List;

import dma.app.model.Application;
import dma.app.model.Student;

public class FewestCoursesStrategy extends TemplateStrategyAlgorithm {
	
	public FewestCoursesStrategy() {
		
	}
	
	@Override
	public Student findApplicant(List<Application> app) {
		int fewestCourses = 50;
		Student student = app.get(0).getStudent();
		
		for( int i = 0; i < app.size(); i++) {
			if (app.get(i).getStudent().getRemainingCourses() < fewestCourses) {
				fewestCourses = app.get(i).getStudent().getRemainingCourses();
				student = app.get(i).getStudent();
				
			}
		}
		return student;	
	}


}