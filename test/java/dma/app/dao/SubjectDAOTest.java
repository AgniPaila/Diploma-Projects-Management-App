package dma.app.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import dma.app.model.Subject;



@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ExtendWith(MockitoExtension.class)
class SubjectDAOTest {
	
	@Autowired 
	SubjectDAO subjectDAO;
		
	@Test
	void testSubjectDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(subjectDAO);
	}

	@Test
	void testFindById() {
		Subject storedSub = subjectDAO.findById(13);
		Assertions.assertNotNull(storedSub);
		Assertions.assertEquals(13, storedSub.getId());
	}
}