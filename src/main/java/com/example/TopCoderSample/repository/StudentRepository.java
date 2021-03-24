package com.example.TopCoderSample.repository;

import com.example.TopCoderSample.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentId(Long studentId);
}
