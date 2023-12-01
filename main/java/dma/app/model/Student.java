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
@Table(name="students")
public class Student{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="fullname")
	private String fullName;
	
	@Column(name="yearofstudies")
	private int yearOfStudies;
	
	@Column(name="currentaveragegrade")
	private double currentAverageGrade;
	
	@Column(name="remainingcourses")
	private int remainingCourses;
	
	@OneToOne(cascade = CascadeType.ALL)  
    @JoinColumn(name = "user_id", referencedColumnName = "id")    
	private User user;
	
	@OneToMany(mappedBy="student")
	private List<Application> applications;
	
	//CONSTRUCTORS 
	public Student() {
		
	}
	
	public Student(int id, String fullName, int yearOfStudies, double currentAverageGrade, int remainingCourses, User user) {
		this.id = id;
		this.fullName = fullName;
		this.yearOfStudies = yearOfStudies;
		this.currentAverageGrade = currentAverageGrade;
		this.remainingCourses = remainingCourses;
		this.user = user;
	}


	public Student(String fullName, int yearOfStudies, double currentAverageGrade, int remainingCourses, User user) {
		this.fullName = fullName;
		this.yearOfStudies = yearOfStudies;
		this.currentAverageGrade = currentAverageGrade;
		this.remainingCourses = remainingCourses;
		this.user = user;
	}
	
	public Student(User user) {
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

	public int getYearOfStudies() {
		return yearOfStudies;
	}

	public void setYearOfStudies(int yearOfStudies) {
		this.yearOfStudies = yearOfStudies;
	}

	public double getCurrentAverageGrade() {
		return currentAverageGrade;
	}

	public void setCurrentAverageGrade(double currentAverageGrade) {
		this.currentAverageGrade = currentAverageGrade;
	}

	public int getRemainingCourses() {
		return remainingCourses;
	}

	public void setRemainingCourses(int remainingCourses) {
		this.remainingCourses = remainingCourses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Student [id=" + id + ", fullName=" + fullName + ", yearOfStudies=" + yearOfStudies
				+ ", currentAverageGrade=" + currentAverageGrade + ", remainingCourses=" + remainingCourses + ", user="
				+ user + ", applications=" + applications + "]";
	}
	
}
