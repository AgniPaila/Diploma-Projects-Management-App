package dma.app.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;


import dma.app.dao.StudentDAO;
import dma.app.model.Role;
import dma.app.model.Student;
import dma.app.model.User;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class StudentServiceImplTest {

	@Autowired
	StudentService studentService;
	
	@MockBean
	StudentDAO studentRepository;
	


	
	
	@Test
	void testProfessorDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(studentService);
	}
	
	@Test
	void testFindById() {
		User user = new User(9,"Maria", "1", Role.STUDENT);
		Mockito.when(studentRepository.findById(1)).thenReturn(new Student(1, "Maria", 4, 7.0, 4, user));
		Student student = studentService.findById(1);
		Assertions.assertNotNull(student);
		Assertions.assertEquals(1, student.getId());
		Assertions.assertEquals("Maria", student.getFullName());
		Assertions.assertEquals(4, student.getYearOfStudies());
		Assertions.assertEquals(7.0, student.getCurrentAverageGrade());
		Assertions.assertEquals(4, student.getRemainingCourses());
	}
	
	
	@Test
	void testSaveProfile() {
		User user = new User(9,"Maria", "1", Role.STUDENT);
		Student student = new Student(1, "Maria", 4, 7.0, 4, user);
		studentService.saveProfile(student);
		verify(studentRepository).save(student);
	}
	
	@Test
	void testFindByUserId() {
		User user = new User(1,"Maria", "1", Role.STUDENT);
		Mockito.when(studentRepository.findByUserId(1)).thenReturn(new Student(1, "Maria", 4, 7.0, 4, user));
		Student storedStudent = studentRepository.findByUserId(1);
		Assertions.assertNotNull(storedStudent);
		Assertions.assertEquals("Maria", storedStudent.getFullName());
		Assertions.assertEquals(4, storedStudent.getYearOfStudies());
		Assertions.assertEquals(7.0, storedStudent.getCurrentAverageGrade());
		Assertions.assertEquals(4, storedStudent.getRemainingCourses());
	}
}
