package dma.app.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="theses")
public class Thesis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="implementationgrade")
	private double implementationGrade;
	
	@Column(name="reportgrade")
	private double reportGrade;
	
	@Column(name="presentationgrade")
	private double presentationGrade;
	
	@Column(name="totalgrade")
	private double totalGrade;

	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

	@ManyToOne
    @JoinColumn(name="professor_id")
	private Professor supervisorProfessor;
	
	
	public Professor getSupervisorProfessor() {
		return supervisorProfessor;
	}

	public void setSupervisorProfessor(Professor supervisorProfessor) {
		this.supervisorProfessor = supervisorProfessor;
	}

	//CONSTRUCTORS 
	public Thesis() {
		
	}

	public Thesis(int id, double implementationGrade, double reportGrade, double presentationGrade,double totalGrade, Student student,
			Subject subject, Professor supervisorProfessor) {
		this.id = id;
		this.implementationGrade = implementationGrade;
		this.reportGrade = reportGrade;
		this.presentationGrade = presentationGrade;
		this.totalGrade = totalGrade;
		this.student = student;
		this.subject = subject;
		this.supervisorProfessor = supervisorProfessor;
	}

	public Thesis(double implementationGrade, double reportGrade, double presentationGrade,double totalGrade, Student student,
			Subject subject, Professor supervisorProfessor) {
		this.implementationGrade = implementationGrade;
		this.reportGrade = reportGrade;
		this.presentationGrade = presentationGrade;
		this.totalGrade = totalGrade;
		this.student = student;
		this.subject = subject;
		this.supervisorProfessor = supervisorProfessor;
	}


	public Thesis(Student student, Subject subject, Professor supervisorProfessor) {
		this.student = student;
		this.subject = subject;
		this.supervisorProfessor = supervisorProfessor;
	}

	//GETTERS,SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getImplementationGrade() {
		return implementationGrade;
	}

	public void setImplementationGrade(double implementationGrade) {
		this.implementationGrade = implementationGrade;
	}

	public double getReportGrade() {
		return reportGrade;
	}

	public void setReportGrade(double reportGrade) {
		this.reportGrade = reportGrade;
	}

	public double getPresentationGrade() {
		return presentationGrade;
	}

	public void setPresentationGrade(double presentationGrade) {
		this.presentationGrade = presentationGrade;
	}
	
	
	public double getTotalGrade() {
		return totalGrade;
	}

	public void setTotalGrade(double totalGrade) {
		this.totalGrade = totalGrade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	


}
