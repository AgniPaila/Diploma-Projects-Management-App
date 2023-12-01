package dma.app.model.strategies;

import java.util.List;

import dma.app.model.Application;
import dma.app.model.Student;

public abstract class TemplateStrategyAlgorithm implements BestApplicantStrategy {
	
	public TemplateStrategyAlgorithm() {
		
	}

	@Override
	public Student findBestApplicant(List<Application> app) {
		Student student = findApplicant(app);
		return student;	
	}

	public abstract Student findApplicant(List<Application> app);

}
