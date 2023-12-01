package dma.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dma.app.model.Professor;

@Repository
public interface ProfessorDAO extends JpaRepository<Professor, Integer> {
	public Professor findById(int theId);
	
	public Professor findByUserId(int theId);
	
}
