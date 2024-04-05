package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.Api.ApiResponse;
import com.example.schoolmanagementsoftware.Model.Course;
import com.example.schoolmanagementsoftware.Service.CourseService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    Logger logger = LoggerFactory.getLogger(CourseController.class);
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourses(){
        logger.info("inside get all courses!");
        return ResponseEntity.ok().body(courseService.getAllCourses());
    }

    @PostMapping("/add/{teacher_id}")
    public ResponseEntity addCourse(@PathVariable Integer teacher_id, @RequestBody @Valid Course course){
        logger.info("inside add course!");
        courseService.addCourse(teacher_id, course);
        return ResponseEntity.ok().body(new ApiResponse("course added successfully into teacher!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @RequestBody @Valid Course course){
        logger.info("inside update course!");
        courseService.updateCourse(id, course);
        return ResponseEntity.ok().body(new ApiResponse("course updated successfully!"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCoures(@PathVariable Integer id){
        logger.info("inside delete course!");
        courseService.deleteCourse(id);
        return ResponseEntity.ok().body(new ApiResponse("course deleted successfully!"));
    }

    @GetMapping("/get-teacher-by-course-id/{course_id}")
    public ResponseEntity getTeacherNameViaCourseId(@PathVariable Integer course_id){
        logger.info("inside get teacher name via course id!");
        return ResponseEntity.ok().body(courseService.getTeacherNameViaCourseId(course_id));

    }
}
