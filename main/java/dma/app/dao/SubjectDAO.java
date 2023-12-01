package dma.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dma.app.model.Subject;

@Repository
public interface SubjectDAO extends JpaRepository<Subject, Integer> {
	
	public Subject findById(int theId);
	

}
