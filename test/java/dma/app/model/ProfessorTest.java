package dma.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProfessorTest {
	
	private Professor prof; 
	
	@BeforeEach
    public void setUp(){
		this.prof = new Professor();
	}
	
	@Test
    public void getSetIdTest() {
        
        this.prof.setId(0);
        assertEquals(0, this.prof.getId());
    }
	
	@Test
    public void getSetFullNameTest() {
        
        this.prof.setFullName("");
        assertEquals("", this.prof.getFullName());
    }
	
	@Test
    public void getSetSpecialtyTest(){
        
        this.prof.setSpecialty("");
        assertEquals("", this.prof.getSpecialty());
    }
	
	@Test
    public void getSetUserTest(){
        User user = new User();
        this.prof.setUser(user);
        assertEquals(user, this.prof.getUser());
    }
	
	@Test
    public void getSetSubjectListTest() {
		List<Subject> subjects = new ArrayList<Subject>();
        this.prof.setSubjects(subjects);
        assertEquals(subjects, this.prof.getSubjects());
    }
	
	@Test
    public void getSetThesesListTest() {
		List<Thesis> theses = new ArrayList<Thesis>();
        this.prof.setTheses(theses);
        assertEquals(theses, this.prof.getTheses());
    }
	
	@Test
    public void constructor1Test() {
		List<Thesis> thes = new ArrayList<Thesis>();
		List<Subject> sub = new ArrayList<Subject>();
        User user = new User();
        this.prof= new Professor(1,"","" ,user,sub, thes);
        assertEquals(1, this.prof.getId());
        assertEquals("", this.prof.getFullName());
        assertEquals("", this.prof.getSpecialty());
        assertEquals(user, this.prof.getUser());
    }
	
	@Test
    public void constructor2Test() {
		List<Thesis> thes = new ArrayList<Thesis>();
		List<Subject> sub = new ArrayList<Subject>();
        User user = new User();
        this.prof = new Professor("","" ,user,sub, thes);
        assertEquals("", this.prof.getFullName());
        assertEquals("", this.prof.getSpecialty());
        assertEquals(user, this.prof.getUser());
    }
	
	@Test
    public void constructor3Test(){
		
        User user = new User();
        this.prof = new Professor(user);
        assertEquals(user, this.prof.getUser());
    }
	
	
}