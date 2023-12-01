package dma.app.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import dma.app.model.Student;



@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ExtendWith(MockitoExtension.class)
class StudentDAOTest {
	
	@Autowired 
	StudentDAO studentDAO;
		
	@Test
	void testStudentDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(studentDAO);
	}

	@Test
	void testFindById() {
		Student storedStud = studentDAO.findById(4);
		Assertions.assertNotNull(storedStud);
		Assertions.assertEquals(4, storedStud.getId());
	}
}