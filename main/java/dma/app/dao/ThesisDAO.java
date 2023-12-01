package dma.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dma.app.model.Thesis;

@Repository
public interface ThesisDAO extends JpaRepository<Thesis, Integer>{

	public Thesis findById(int theId);

}
