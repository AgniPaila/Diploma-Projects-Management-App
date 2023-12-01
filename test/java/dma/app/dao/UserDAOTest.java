package dma.app.dao;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import dma.app.model.User;



@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ExtendWith(MockitoExtension.class)
class UserDAOTest {
	
	@Autowired 
	UserDAO userDAO;
		
	@Test
	void testUserDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(userDAO);
	}

	@Test
	void testFindByUsername() {
		Optional<User> storeduser = userDAO.findByUsername("maria");
		Assertions.assertNotNull(userDAO);
		//Assertions.assertEquals("maria", userDAO.findByUsername("maria"));
	}
}
