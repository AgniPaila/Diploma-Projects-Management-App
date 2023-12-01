package dma.app.model.strategies;



public class BestApplicantStrategyFactory {
	
	
	
	public BestApplicantStrategyFactory() {
		
	}
	
	
	public BestApplicantStrategy createStrategy(String strategy, double th1, int th2) {
		
		
		if (strategy == "BestAvgGrade") {
			return new BestAvgGradeStrategy();
		}
		else if ( strategy == "FewestCourses") {
			return new FewestCoursesStrategy();
		}
		else if ( strategy == "RandomChoice") {
			return new RandomChoiceStrategy();
		}
		else if ( strategy == "Threshold") {
			return new ThresholdStrategy(th1, th2);
		}
		else {
			return null;
		}

	}

}
