package dma.app.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import dma.app.dao.ThesisDAO;
import dma.app.model.Role;
import dma.app.model.Student;
import dma.app.model.Subject;
import dma.app.model.Thesis;
import dma.app.model.User;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ThesisServiceImplTest {
	
	
	@Autowired
	ThesisService thesisService;
	
	
	@MockBean
	ThesisDAO thesisRepository;
	
	
	@Test
	void testThesisDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(thesisService);
	}
	
	
	@Test
	void testSave() {
		User user = new User(9,"Maria", "1", Role.PROFESSOR);
		Student student = new Student(1, "Maria", 4, 7.0, 4, user);
		Subject subject = new Subject(1,"Software","software", null, null, true);
		Thesis thesis = new Thesis(1, 10.0, 10.0, 10.0, student, subject, null );
		thesisService.save(thesis);
		verify(thesisRepository).save(thesis);	
	}
	
	@Test
	void testFindById() {
		Mockito.when(thesisRepository.findById(0)).thenReturn(new Thesis(0, 10.0, 10.0, 10.0, null, null, null));
		Thesis thesis = thesisRepository.findById(0);
		Assertions.assertNotNull(thesis);
		Assertions.assertEquals(0, thesis.getId());
	}
	
	@Test
	void testCalculateGrade() {
		//Thesis thesis = new Thesis(0, 10.0, 10.0, 10.0, null, null, null);
		Double totalGrade = thesisService.calculateGrade(10, 10, 10);
		Assertions.assertEquals(10, totalGrade);
	}

}
