package dma.app.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import dma.app.model.Thesis;



@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ExtendWith(MockitoExtension.class)
class ThesisDAOTest {
	
	@Autowired 
	ThesisDAO thesisDAO;
		
	@Test
	void testThesisDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(thesisDAO);
	}

	@Test
	void testFindById() {
		Thesis storedThesis = thesisDAO.findById(8);
		Assertions.assertNotNull(storedThesis);
		Assertions.assertEquals(8, storedThesis.getId());
	}
}