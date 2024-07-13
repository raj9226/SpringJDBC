package com.raj.SpringJDBCEx.Service;

import com.raj.SpringJDBCEx.Model.Students;
import com.raj.SpringJDBCEx.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepo;
    public void addStudent(Students s) {

        studentRepo.save(s);

    }

    public List<Students> getAllStudents() {
        return studentRepo.findAll();
    }
}
