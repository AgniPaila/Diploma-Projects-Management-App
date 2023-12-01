package dma.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SubjectTest {
	
	private Subject sub; 
	
	@BeforeEach
    public void setUp() {
		this.sub = new Subject();
	}
	
	@Test
    public void getSetIdTest() {
        
        this.sub.setId(0);
        assertEquals(0, this.sub.getId());
    }
	
	@Test
    public void getSetTitleTest() {
        
        this.sub.setTitle("");
        assertEquals("", this.sub.getTitle());
    }
	
	@Test
    public void getSetObjectivesTest() {
        
        this.sub.setObjectives("");
        assertEquals("", this.sub.getObjectives());
    }
	
	@Test
    public void getSetSupervisorProfessorTest() {
        
		Professor superProf = new Professor();
        this.sub.setSupervisorProfessor(superProf);
        assertEquals(superProf, this.sub.getSupervisorProfessor());
    }
	
	@Test
    public void getSetApplicationListTest(){
		List<Application> apps = new ArrayList<Application>();
        this.sub.setApplications(apps);
        assertEquals(apps, this.sub.getApplications());
    }
	
	
	@Test
    public void getSetAvailableTest() {
        
        this.sub.setAvailable(true);
        assertTrue(this.sub.getAvailable());
    }
	
	@Test
    public void constructor1Test() {
		
        Professor superprof = new Professor();
        List<Application> apps = new ArrayList<Application>();
        this.sub= new Subject(1,"","",superprof,apps,true);
        assertEquals(1, this.sub.getId());
        assertEquals("", this.sub.getTitle());
        assertEquals("", this.sub.getObjectives());
        assertEquals(superprof, this.sub.getSupervisorProfessor());
        assertEquals(apps, this.sub.getApplications());
    }
	
	@Test
    public void constructor2Test() {
		
        Professor superprof = new Professor();
        List<Application> apps = new ArrayList<Application>();
        this.sub = new Subject("", "", superprof, apps, true);
        assertEquals("", this.sub.getTitle());
        assertEquals("", this.sub.getObjectives());
        assertEquals(superprof, this.sub.getSupervisorProfessor());
        assertEquals(apps, this.sub.getApplications());
    }
	
	@Test
    public void constructor3Test() {
		
		Professor superprof = new Professor();
        this.sub = new Subject(superprof);
        assertEquals(superprof, this.sub.getSupervisorProfessor());
    }
}