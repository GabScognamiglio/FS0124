package it.epicode.lezione_jwt.service;

import it.epicode.lezione_jwt.dto.StudentDto;
import it.epicode.lezione_jwt.entity.Student;
import it.epicode.lezione_jwt.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public String saveStudent(StudentDto studentDto) {
     Student student = new Student();
     student.setName(studentDto.getName());
     student.setSurname(studentDto.getSurname());
     student.setDateOfBirth(studentDto.getDateOfBirth());

     studentRepository.save(student);

     return "Student with ID: " + student.getId() + " correctly saved.";
    }
}
