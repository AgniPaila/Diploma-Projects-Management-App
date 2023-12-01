package dma.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="applications")
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
    @JoinColumn(name="subject_id")
	private Subject subject;
	
	@ManyToOne
    @JoinColumn(name="student_id")
	private Student student;
	
	
	//CONSTRUCTORS 
	public Application() {
			
	}

	public Application(int id, Subject subject, Student student) {
		this.id = id;
		this.subject = subject;
		this.student = student;
	}

	public Application(Subject subject, Student student) {
		this.subject = subject;
		this.student = student;
	}

	//GETTERS,SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}