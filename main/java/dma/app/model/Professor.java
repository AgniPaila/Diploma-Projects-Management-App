package dma.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="professors")
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="fullname")
	private String fullName;
	
	@Column(name="specialty")
	private String specialty;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
	
	
	@OneToMany(mappedBy="supervisorProfessor")
	private List<Subject> subjects;
	
	
	@OneToMany(mappedBy="supervisorProfessor")
	private List<Thesis> theses;

	
	public List<Thesis> getTheses() {
		return theses;
	}

	public void setTheses(List<Thesis> theses) {
		this.theses = theses;
	}

	//CONSTRUCTORS 
	public Professor() {
		
	}
	
	public Professor(int id, String fullName, String specialty, User user, List<Subject> subjects, List<Thesis> theses) {
		this.id = id;
		this.fullName = fullName;
		this.specialty = specialty;
		this.user = user;
		this.subjects = subjects;
		this.theses = theses;
	}

	public Professor(String fullName, String specialty, User user, List<Subject> subjects, List<Thesis> theses) {
		this.fullName = fullName;
		this.specialty = specialty;
		this.user = user;
		this.subjects = subjects;
		this.theses = theses;
	}
	
	public Professor(User user) {
		this.user = user;
	}

	//GETTERS,SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
	
}
