package com.school_automation.service;

import com.school_automation.dto.CreateStudentForm;
import com.school_automation.entity.StudentEntity;
import com.school_automation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> getAll()
    {
        Iterator<StudentEntity> studentsIt = studentRepository.findAll().iterator();
        List<StudentEntity> students = new ArrayList<>();

        studentsIt.forEachRemaining(students::add);

        return students;
    }

    @PutMapping
    public void createStudent(CreateStudentForm createStudentForm)
    {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setYourClass(createStudentForm.getYourClass());
        studentEntity.setName(createStudentForm.getName());

        studentRepository.save(studentEntity);
    }

    @PostMapping
    public void updateStudent(CreateStudentForm createStudentForm)
    {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setYourClass(createStudentForm.getYourClass());
        studentEntity.setName(createStudentForm.getName());

        studentRepository.save(studentEntity);
    }

    @DeleteMapping
    public void deleteStudent(CreateStudentForm createStudentForm)
    {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setYourClass(createStudentForm.getYourClass());
        studentEntity.setName(createStudentForm.getName());

        studentRepository.save(studentEntity);
    }
}
