package dma.app.model.strategies;

import java.util.List;

import dma.app.model.Application;
import dma.app.model.Student;

public class RandomChoiceStrategy extends TemplateStrategyAlgorithm {
	
	public RandomChoiceStrategy(){}
	
	
	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	@Override
	public Student findApplicant(List<Application> app) {
		int listSize = app.size();
		int randomNumber = getRandomNumber(0,listSize);
		Student student = app.get(0).getStudent();
		
		if (app.get(randomNumber) != null) {
			return app.get(randomNumber).getStudent();
		}
		else {
			return student;	
		}
	}
}
