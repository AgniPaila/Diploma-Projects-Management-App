package dma.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dma.app.dao.StudentDAO;
import dma.app.model.Student;


@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentDAO theStudentRepository) {
		studentRepository = theStudentRepository;
	}
	
	public StudentServiceImpl() {
	
	}
	

	@Override
	@Transactional
	public Student findById(int theId) {
		Student result = studentRepository.findById(theId);
				
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the student
			throw new RuntimeException("Did not find student id - " + theId);
		}
	}

	@Override
	@Transactional
	public void saveProfile(Student student) {
		studentRepository.save(student);
	}

	
	@Override
	@Transactional
	public Student findByUserId(int theId) {
		Student result = studentRepository.findByUserId(theId);
				
		return result;
	}
	
    
}
