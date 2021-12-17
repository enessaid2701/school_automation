package com.school_automation.service;

import com.school_automation.entity.TeacherEntity;
import com.school_automation.form.CreateStudentForm;
import com.school_automation.entity.StudentEntity;
import com.school_automation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

    public StudentEntity getStudentById(Long id){
        return studentRepository.findById(id).get();
    }

    public StudentEntity getStudentByUserName(String userName){
        return studentRepository.findStudentEntityByUserName(userName);
    }

    public void createStudent(CreateStudentForm createStudentForm)
    {
        StudentEntity studentEntity;
        if (createStudentForm.getId() == null) {
            studentEntity = new StudentEntity();
        }else{
            Optional<StudentEntity> studentEntityOptional = studentRepository.findById(createStudentForm.getId());
            studentEntity = studentEntityOptional.orElseGet(StudentEntity::new);
        }

        studentEntity.setYourClass(createStudentForm.getYourClass());
        studentEntity.setName(createStudentForm.getName());
        studentEntity.setUserName(createStudentForm.getUserName());
        studentEntity.setPassword(createStudentForm.getPassword());

        studentRepository.save(studentEntity);
    }

    public void updateStudent(CreateStudentForm createStudentForm)
    {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setYourClass(createStudentForm.getYourClass());
        studentEntity.setName(createStudentForm.getName());
        studentEntity.setUserName(createStudentForm.getUserName());
        studentEntity.setPassword(createStudentForm.getPassword());

        studentRepository.save(studentEntity);
    }

    public void deleteStudent(Long id)
    {
        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(id);
        studentEntityOptional.ifPresent(studentEntity -> studentRepository.delete(studentEntity));
    }
}
