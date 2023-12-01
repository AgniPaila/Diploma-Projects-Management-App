package dma.app.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import dma.app.service.ApplicationService;
import dma.app.service.StudentService;
import dma.app.service.SubjectService;
import dma.app.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureMockMvc
public class ProfessorControllerTest {
	
	@Autowired
    private WebApplicationContext context;
	
	@Autowired                           
    private MockMvc mockMvc;
	
	@MockBean
	StudentService studentService;
	
	@MockBean
	UserService userService;
	
	
	@MockBean
	SubjectService subjectService;
	
	@MockBean
	ApplicationService applicationService;
	
	
	@Autowired
	ProfessorController professorController;
	
	
	@Mock
	private Authentication auth;

	
	
	@BeforeEach
    public void setup() {
		mockMvc = MockMvcBuilders
          .webAppContextSetup(context)
          .build();
		//System.exit(0);
    }
	
	
	@Test
	void testStudentControllerIsNotNull() {
		Assertions.assertNotNull(professorController);
	}
	
	@Test
	void testMockMvcIsNotNull() {
		Assertions.assertNotNull(mockMvc);
	}

}
