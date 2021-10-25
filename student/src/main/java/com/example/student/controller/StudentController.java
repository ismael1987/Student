package com.example.student.controller;

import com.example.student.exception.ResourceNotFoundException;
import com.example.student.model.Student;
import com.example.student.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    //getAll student
    @GetMapping("/students")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //create Student
    @PostMapping("/students")
    @CrossOrigin(origins = "http://localhost:4200")
    public Student addNewStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    //get student by id
    @GetMapping("/students/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Student>  getStudentById(@PathVariable Long id){
        Student student = studentRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found with id :" +id));
        return ResponseEntity.ok(student);
    }

    //edit student by id
    @PutMapping("/students/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Student>  editStudentById(@PathVariable Long id, @RequestBody Student studentDetails){
        Student student = studentRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found with id :" +id));
        student.setFirstName(studentDetails.getFirstName());
        student.setFirstName(studentDetails.getLastName());
        student.setFirstName(studentDetails.getSchoolClass());
        Student updatedStudent = studentRepository.save(student);

        return ResponseEntity.ok(updatedStudent);
    }

    // delet student
    @DeleteMapping("/students/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id){

        Student student = studentRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found with id :" +id));
        studentRepository.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  ResponseEntity.ok(response);
    }
}
