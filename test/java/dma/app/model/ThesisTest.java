package dma.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ThesisTest {
	
	private Thesis thesis; 
	
	@BeforeEach
    public void setUp() {
		this.thesis = new Thesis();
	}
	
	@Test
    public void getSetIdTest() {
        
        this.thesis.setId(0);
        assertEquals(0, this.thesis.getId());
    }
	
	@Test
    public void getSetImplementationGradeTest() {
        
        this.thesis.setImplementationGrade(0.0);
        assertEquals(0.0, this.thesis.getImplementationGrade());
    }
	
	@Test
    public void getSetReportGradeTest() {
        
        this.thesis.setReportGrade(0.0);
        assertEquals(0.0, this.thesis.getReportGrade());
    }
	
	
	@Test
    public void getSetPresentationGradeTest(){
        
        this.thesis.setPresentationGrade(0.0);
        assertEquals(0.0, this.thesis.getPresentationGrade());
    }
	
	
	@Test
    public void getSetTotalGradeTest() {
        
        this.thesis.setTotalGrade(0.0);
        assertEquals(0.0, this.thesis.getTotalGrade());
    }
	
	@Test
    public void getSetStudentTest() {
        Student stud = new Student();
        this.thesis.setStudent(stud);
        assertEquals(stud, this.thesis.getStudent());
    }
	
	@Test
    public void getSetSubjectTest(){
        Subject sub = new Subject();
        this.thesis.setSubject(sub);
        assertEquals(sub, this.thesis.getSubject());
    }
	
	@Test
    public void constructor1Test() {
		
		Professor superprof = new Professor();
        Subject sub = new Subject();
		Student stud = new Student();
        this.thesis= new Thesis(0,0.0, 0.0, 0.0, 0.0, stud, sub, superprof);
        assertEquals(0, this.thesis.getId());
        assertEquals(0.0, this.thesis.getImplementationGrade());
        assertEquals(0.0, this.thesis.getReportGrade());
        assertEquals(0.0, this.thesis.getPresentationGrade());
        assertEquals(0.0, this.thesis.getTotalGrade());
        assertEquals(stud, this.thesis.getStudent());
        assertEquals(sub, this.thesis.getSubject());
        assertEquals(superprof, this.thesis.getSupervisorProfessor());
        
    }
	
	@Test
    public void constructor2Test(){
		
        Professor superprof = new Professor();
        Subject sub = new Subject();
		Student stud = new Student();
        this.thesis= new Thesis(0.0, 0.0, 0.0, 0.0, stud, sub, superprof);
        assertEquals(0.0, this.thesis.getImplementationGrade());
        assertEquals(0.0, this.thesis.getReportGrade());
        assertEquals(0.0, this.thesis.getPresentationGrade());
        assertEquals(0.0, this.thesis.getTotalGrade());
        assertEquals(stud, this.thesis.getStudent());
        assertEquals(sub, this.thesis.getSubject());
        assertEquals(superprof, this.thesis.getSupervisorProfessor());
    }
	
	@Test
    public void constructor3Test() {
			
		Subject sub = new Subject();
		Student stud = new Student();
		Professor superprof = new Professor();
		
        this.thesis = new Thesis(stud,sub,superprof);
        assertEquals(sub, this.thesis.getSubject());
        assertEquals(stud, this.thesis.getStudent());
        assertEquals(superprof, this.thesis.getSupervisorProfessor());
    }
}
