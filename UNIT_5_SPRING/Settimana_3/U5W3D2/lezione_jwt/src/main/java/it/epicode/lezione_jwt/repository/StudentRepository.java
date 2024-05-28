package it.epicode.lezione_jwt.repository;

import it.epicode.lezione_jwt.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
