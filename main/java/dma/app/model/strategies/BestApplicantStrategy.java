package dma.app.model.strategies;
import java.util.List;

import dma.app.model.Application;
import dma.app.model.Student;


public interface BestApplicantStrategy {
	
	public Student findBestApplicant(List<Application> app);
	
	

}
