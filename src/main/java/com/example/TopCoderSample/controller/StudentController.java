package com.example.TopCoderSample.controller;

import com.example.TopCoderSample.entity.Student;
import com.example.TopCoderSample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents() {
        // get all students from db
        return studentRepository.findAll();
    }

    @GetMapping(value = "/student/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentById(@PathVariable Long studentId) {
        return studentRepository.findByStudentId(studentId);
    }

    @PostMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student addStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PutMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student editStudent(@RequestBody Student student){
        Student existingStudent = studentRepository.findByStudentId(student.getStudentId());
        existingStudent.setName(student.getName());
        existingStudent.setGrade(student.getGrade());
        return studentRepository.save(student);
    }

    @DeleteMapping(value = "/student/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteStudent(@PathVariable Long studentId){
         studentRepository.deleteById(studentId);
         return "Student successfully deleted";
    }
}
