package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.Model.Student;
import com.example.schoolmanagementsoftware.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;


    @GetMapping("/get")
    public ResponseEntity getAllStudents(){
        logger.info("inside get all students");
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        logger.info("inside add Student");
        studentService.addStudent(student);
        return ResponseEntity.ok().body("student added successfully!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @RequestBody @Valid Student student){
        logger.info("inside update sutdnet!");
        studentService.updateStudent(id, student);
        return ResponseEntity.ok().body("student updated succesffully!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        logger.info("inside delete student!");
        studentService.deleteStudent(id);
        return ResponseEntity.ok().body("student deleted successfully!");
    }

    @PutMapping("/change-student-major/{id}/{newMajor}")
    public ResponseEntity changeStudentMajor(@PathVariable Integer id, @PathVariable String newMajor){
        logger.info("inside change student major!");
        studentService.changeStudentMajor(id, newMajor);
        return ResponseEntity.ok().body("student's major changed successfully!");
    }

    @GetMapping("/get/{courseId}")
    public ResponseEntity getStudentsByCourseId(@PathVariable Integer courseId){
        logger.info("inside get students by course id!");
        return ResponseEntity.ok().body(studentService.getStudentsByCourseId(courseId));
    }

}
