package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    Logger logger = LoggerFactory.getLogger(TeacherController.class);
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeachers(){
        logger.info("inside get all Teacher");
        return ResponseEntity.ok().body(teacherService.getAllTeachers());
    }


    @PostMapping("/add")
    public ResponseEntity addTeaher(@RequestBody @Valid Teacher teacher){
        logger.info("inside add Teacher");
        teacherService.addTeacher(teacher);
        return ResponseEntity.ok().body("teacher added successfully!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher){
        logger.info("inside update Teacher");
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.ok().body("teacher updated successfully!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        logger.info("inside delete Teacher");
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok().body("teacher deleted successfully!");
    }

    @GetMapping("/get-teacher-details/{id}")
    public ResponseEntity getTeacherDetails(@PathVariable Integer id){
        logger.info("inside get Teacher details");
        return ResponseEntity.ok().body(teacherService.getTeacherDetails(id));
    }
}
