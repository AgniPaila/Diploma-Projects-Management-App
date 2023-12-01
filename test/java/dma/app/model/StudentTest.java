package dma.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentTest {
	
	private Student stud; 
	
	@BeforeEach
    public void setUp() {
		this.stud = new Student();
	}
	
	@Test
    public void getSetIdTest(){
        
        this.stud.setId(0);
        assertEquals(0, this.stud.getId());
    }
	
	@Test
    public void getSetFullNameTest() {
        
        this.stud.setFullName("");
        assertEquals("", this.stud.getFullName());
    }
	
	@Test
    public void getSetYearOfStudiesTest() {
        
        this.stud.setYearOfStudies(0);
        assertEquals(0, this.stud.getYearOfStudies());
    }
	
	@Test
    public void getSetCurrentAverageGradeTest() {
        
        this.stud.setCurrentAverageGrade(0.0);
        assertEquals(0.0, this.stud.getCurrentAverageGrade());
    }
	
	@Test
    public void getSetRemainingCourses(){
        
        this.stud.setRemainingCourses(0);
        assertEquals(0, this.stud.getRemainingCourses());
    }
	
	@Test
    public void getSetUserTest(){
        User user = new User();
        this.stud.setUser(user);
        assertEquals(user, this.stud.getUser());
    }
	
	@Test
    public void getSetApplicationListTest(){
		List<Application> apps = new ArrayList<Application>();
        this.stud.setApplications(apps);
        assertEquals(apps, this.stud.getApplications());
    }
	
	
	@Test
    public void constructor1Test() {
		
        User user = new User();
        this.stud = new Student(1,"",0,0.0,0 ,user);
        assertEquals(1, this.stud.getId());
        assertEquals("", this.stud.getFullName());
        assertEquals(0, this.stud.getYearOfStudies());
        assertEquals(0.0, this.stud.getCurrentAverageGrade());
        assertEquals(0, this.stud.getRemainingCourses());
        assertEquals(user, this.stud.getUser());
    }
	
	@Test
    public void constructor2Test( ){
		User user = new User();
        this.stud = new Student("",0,0.0,0 ,user);
        assertEquals("", this.stud.getFullName());
        assertEquals(0, this.stud.getYearOfStudies());
        assertEquals(0.0, this.stud.getCurrentAverageGrade());
        assertEquals(0, this.stud.getRemainingCourses());
        assertEquals(user, this.stud.getUser());
	}
	
	@Test
    public void constructor3Test() {
		
        User user = new User();
        this.stud= new Student(user);
        assertEquals(user, this.stud.getUser());
    }
	
}
