package dma.app.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;


import dma.app.dao.ProfessorDAO;
import dma.app.model.Professor;
import dma.app.model.Role;
import dma.app.model.User;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorServiceImplTest {
	
	
	@Autowired
	ProfessorService professorService;
	
	@Autowired
	ThesisService thesisService;
	
	@MockBean
	ProfessorDAO professorRepository;
	
	@Test
	void testProfessorDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(professorService);
	}
	
	
	
	@Test
	void testFindByUserId() {
		User user = new User(9,"Maria", "1", Role.PROFESSOR);
		
		Mockito.when(professorRepository.findByUserId(9)).thenReturn(new Professor(9, "Maria", "Software", user, null, null));
		
		Professor storedProfessor = professorRepository.findByUserId(9);
		Assertions.assertNotNull(storedProfessor);
		Assertions.assertEquals("Maria", storedProfessor.getFullName());
		Assertions.assertEquals("Software", storedProfessor.getSpecialty());
	}
	
	
	@Test
	void testSaveProfile() {
		User user = new User(9,"Maria", "1", Role.PROFESSOR);
		Professor professor = new Professor(9, "Maria", "Software", user, null, null);
		professorService.saveProfile(professor);
		verify(professorRepository).save(professor);

	}
	
	

}
