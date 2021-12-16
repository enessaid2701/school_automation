package com.school_automation.service;

import com.school_automation.dto.CreateTeacherForm;
import com.school_automation.entity.TeacherEntity;
import com.school_automation.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TeacherService
{
    @Autowired
    private TeacherRepository teacherRepository;

    public List<TeacherEntity> getAll()
    {
        Iterator<TeacherEntity> teachersIt = teacherRepository.findAll().iterator();
        List<TeacherEntity> teachers = new ArrayList<>();

        teachersIt.forEachRemaining(teachers::add);

        return teachers;
    }

    @PutMapping
    public void createTeacher(CreateTeacherForm createTeacherForm)
    {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setBranch(createTeacherForm.getBranch());
        teacherEntity.setName(createTeacherForm.getName());
        teacherEntity.setPassword(createTeacherForm.getPassword());
        teacherEntity.setUserName(createTeacherForm.getUserName());

        teacherRepository.save(teacherEntity);
    }

    @PostMapping
    public void updateTeacher(CreateTeacherForm createTeacherForm)
    {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setBranch(createTeacherForm.getBranch());
        teacherEntity.setName(createTeacherForm.getName());
        teacherEntity.setPassword(createTeacherForm.getPassword());
        teacherEntity.setUserName(createTeacherForm.getUserName());

        teacherRepository.save(teacherEntity);
    }

    @DeleteMapping
    public void deleteTeacher(CreateTeacherForm createTeacherForm)
    {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setBranch(createTeacherForm.getBranch());
        teacherEntity.setName(createTeacherForm.getName());
        teacherEntity.setPassword(createTeacherForm.getPassword());
        teacherEntity.setUserName(createTeacherForm.getUserName());

        teacherRepository.save(teacherEntity);
    }
}
