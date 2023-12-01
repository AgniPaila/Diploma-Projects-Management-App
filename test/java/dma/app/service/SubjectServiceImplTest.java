package dma.app.service;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import dma.app.dao.SubjectDAO;
import dma.app.model.Professor;
import dma.app.model.Role;
import dma.app.model.Subject;
import dma.app.model.User;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class SubjectServiceImplTest {
	
	@Autowired
	SubjectService subjectService;
	
	
	@MockBean
	SubjectDAO subjectRepository;
	
	@Test
	void testSubjectDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(subjectService);
	}
	
	
	@Test
	void testFindAll() {
		List<Subject> subjects = new ArrayList<Subject>();
		
		subjects.add(new Subject(1,"math","math",null, null, true));
		subjects.add(new Subject(2,"history","history",null, null, true));
		subjects.add(new Subject(3,"physics","physics",null, null, true));
		Mockito.when(subjectRepository.findAll()).thenReturn(subjects);
		Assertions.assertEquals(3,subjectService.findAll().size());
	}
	
	
	@Test
	void testfindById() {
		Mockito.when(subjectRepository.findById(1)).thenReturn(new Subject(1,"math","math",null, null, true));
		Subject subject = subjectRepository.findById(1);
		Assertions.assertNotNull(subject);
		Assertions.assertEquals(1, subject.getId());
	}
	
	
	@Test
	void testSave() {
		User user = new User(9,"Maria", "1", Role.PROFESSOR);
		Professor professor = new Professor(9, "Maria", "Software", user, null, null);
		Subject subject = new Subject(1,"Software","software", professor, null, true);
		subjectService.save(subject);
		verify(subjectRepository).save(subject);
	}
	
	
	@Test
	void testDeleteById() {
		subjectService.deleteById(1);
		verify(subjectRepository).deleteById(1);
	}

}
