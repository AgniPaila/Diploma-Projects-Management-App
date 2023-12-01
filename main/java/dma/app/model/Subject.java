package dma.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="subjects")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="objectives")
	private String objectives;
	
	@ManyToOne
    @JoinColumn(name="professor_id")
	private Professor supervisorProfessor;
	
	@OneToMany(mappedBy="subject")
	private List<Application> applications;
	
	@Column(name="is_available")
	private boolean isAvailable = true; 
	
	
	//CONSTRUCTORS 
	public Subject() {
		
	}
	
	public Subject(int id, String title, String objectives, Professor supervisorProfessor,
			List<Application> applications, boolean isAvailable) {
		this.id = id;
		this.title = title;
		this.objectives = objectives;
		this.supervisorProfessor = supervisorProfessor;
		this.applications = applications;
		this.isAvailable = isAvailable;
	}

	public Subject(String title, String objectives, Professor supervisorProfessor, List<Application> applications, boolean isAvailable) {
		this.title = title;
		this.objectives = objectives;
		this.supervisorProfessor = supervisorProfessor;
		this.applications = applications;
		this.isAvailable = isAvailable;
	}
	
	public Subject(Professor supervisorProfessor) {
		this.supervisorProfessor = supervisorProfessor;
	}

	

	//GETTERS,SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getObjectives() {
		return objectives;
	}

	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}

	public Professor getSupervisorProfessor() {
		return supervisorProfessor;
	}

	public void setSupervisorProfessor(Professor supervisorProfessor) {
		this.supervisorProfessor = supervisorProfessor;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	
	public boolean getAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
}
