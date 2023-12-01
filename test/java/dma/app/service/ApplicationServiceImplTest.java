package dma.app.service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import dma.app.dao.ApplicationDAO;
import dma.app.model.Application;
import dma.app.model.Student;
import dma.app.model.Subject;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ApplicationServiceImplTest {

	@Autowired
	ApplicationService applicationService;
	
	
	@MockBean
	ApplicationDAO applicationRepository;
	
	
	@Test
	void testProfessorDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(applicationService);
	}
	
	
	@Test
	void testFindById() {
		Mockito.when(applicationRepository.findById(1)).thenReturn(new Application(1, null, null));
		Application application = applicationService.findById(1);
		Assertions.assertNotNull(application);
		Assertions.assertEquals(1, application.getId());
	}
	
	
	@Test
	void testSave() {
		Student student = new Student(1, "Marina", 4, 5.0, 4, null);
		Application application = new Application(1, null, student);
		applicationService.save(application);
		verify(applicationRepository).save(application);
	}
	
	
	@Test
	void testFindBySubjectId() {
		Subject subject = new Subject(1,"Math", "Math operations", null, null, true);
		Mockito.when(applicationRepository.findBySubjectId(1)).thenReturn(new Application(1, subject, null));
		Application application = applicationRepository.findBySubjectId(1);
		Assertions.assertNotNull(application);
		Assertions.assertEquals(1, application.getId());

	}
	
}
