package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.Api.ApiException;
import com.example.schoolmanagementsoftware.Model.Course;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repository.CourseRepository;
import com.example.schoolmanagementsoftware.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public void addCourse(Integer teacher_id, Course course){
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        if (teacher == null){
            throw new ApiException("can't assign, teacher id not found!");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course){
        Course c = courseRepository.findCourseById(id);
        if (c==null){
            throw new ApiException("course not found!");
        }
        c.setName(course.getName());
        courseRepository.save(c);
    }

    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);
        if (course==null){
            throw new ApiException("coures id not found!");
        }
        courseRepository.delete(course);
    }


    public String getTeacherNameViaCourseId(Integer course_id){
        Course c = courseRepository.findCourseById(course_id);
        if (c==null){
            throw new ApiException("course id not found!");
        }
        Teacher teacher = c.getTeacher();
        if (teacher==null){
            throw new ApiException("teacher not found for this course!");
        }
        return teacher.getName();
    }

}
