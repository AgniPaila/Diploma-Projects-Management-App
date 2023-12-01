package dma.app.service;


import org.springframework.stereotype.Service;

import dma.app.model.Student;


@Service
public interface StudentService {
    public void saveProfile(Student student);
    public Student findById(int theId);
    public Student findByUserId(int theId);
}

