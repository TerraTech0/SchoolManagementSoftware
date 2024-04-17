package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.Api.ApiException;
import com.example.schoolmanagementsoftware.Model.Student;
import com.example.schoolmanagementsoftware.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student){
        Student s = studentRepository.findStudentById(id);
        if (student == null){
            throw new ApiException("student not found!");
        }

        s.setAge(student.getAge());
        s.setMajor(student.getMajor());
        s.setName(student.getName());
        s.setCourses(student.getCourses());
        studentRepository.save(s);
    }

    public void deleteStudent(Integer id){
        Student student = studentRepository.findStudentById(id);
        if (id == null){
            throw new ApiException("student not found!");
        }
        studentRepository.delete(student);
    }


    public void changeStudentMajor(Integer id, String newMajor) {
        Student student = studentRepository.findStudentById(id);
        if (student == null) {
            throw new ApiException("Student not found!");
        }
        student.setCourses(new ArrayList<>());
        student.setMajor(newMajor);
        studentRepository.save(student);
    }

    public List<Student> getStudentsByCourseId(Integer courseId) {
        return studentRepository.findStudentsByCourseId(courseId);
    }

}
