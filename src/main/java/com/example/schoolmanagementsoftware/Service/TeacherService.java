package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.Api.ApiException;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher){
        Teacher t = teacherRepository.findTeacherById(id);
        if (t==null){
            throw new ApiException("teacher not found!");
        }
        t.setName(teacher.getName());
        t.setEmail(teacher.getEmail());
        t.setAge(teacher.getAge());
        t.setSalary(teacher.getSalary());
        t.setAddress(teacher.getAddress());
        teacherRepository.save(t);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher==null){
            throw new ApiException("teacher not found!");
        }
    }

    //Create endpoint that takes teacher id and return All teacher details
    public Teacher getTeacherDetails(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null){
            throw new ApiException("teacher not found!");
        }
        return teacher;
    }
}
