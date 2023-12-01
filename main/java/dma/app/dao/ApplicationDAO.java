package dma.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dma.app.model.Application;

@Repository
public interface ApplicationDAO extends JpaRepository<Application, Integer> {
	
	public Application findById(int theId);
	public Application findBySubjectId(int theId);
	
}
