package dma.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import dma.app.dao.ThesisDAO;
import dma.app.model.Thesis;


@Service
public class ThesisServiceImpl implements ThesisService{

	@Autowired
	private ThesisDAO thesisRepository;
	
	@Override
	@Transactional
	public void save(Thesis thesis) {
		thesisRepository.save(thesis);
	}
	
	@Override
	@Transactional
	public Thesis findById(int theId) {
		Thesis result = thesisRepository.findById(theId);
				
		return result;
	}
	
	@Override
	public double calculateGrade(double implGrade, double repGrade, double presGrade) {
		double totalGrade = 0.7*implGrade + 0.15*repGrade + 0.15*presGrade;
		return totalGrade;
	}
}
