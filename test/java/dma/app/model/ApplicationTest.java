package dma.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ApplicationTest {
	private Application app; 
	
	@BeforeEach
    public void setUp(){this.app = new Application();}
	
	@Test
    public void getSetIdTest(){
        
        this.app.setId(0);
        assertEquals(0, this.app.getId());
    }
	
	@Test
    public void getSetSubjectTest(){
		Subject testSub = new Subject();
        this.app.setSubject(testSub);
        assertEquals(testSub, this.app.getSubject());
    }
	
	@Test
    public void getSetStudentTest(){
        Student testStud = new Student();
        this.app.setStudent(testStud);
        assertEquals(testStud, this.app.getStudent());
    }
	
	
	
	@Test
    public void constructor1Test(){
        Subject testSub = new Subject();
        Student testStud = new Student();
        this.app= new Application(1,testSub, testStud);
        assertEquals(1, this.app.getId());
        assertEquals(testSub, this.app.getSubject());
        assertEquals(testStud, this.app.getStudent());
    }
	
	@Test
    public void constructor2Test(){
        Subject testSub = new Subject();
        Student testStud = new Student();
        this.app= new Application(testSub, testStud);
        assertEquals(testSub, this.app.getSubject());
        assertEquals(testStud, this.app.getStudent());
    }
	
	

}
