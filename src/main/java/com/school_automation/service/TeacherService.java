package com.school_automation.service;

import com.school_automation.form.CreateTeacherForm;
import com.school_automation.entity.TeacherEntity;
import com.school_automation.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

    public TeacherEntity getTeacherById(Long id){
        return teacherRepository.findById(id).get();
    }
    public TeacherEntity getTeacherByUserName(String userName){
        return teacherRepository.findTeacherEntityByUserName(userName);
    }

    public void createTeacher(CreateTeacherForm createTeacherForm)
    {

        TeacherEntity teacherEntity;
        if (createTeacherForm.getId() == null) {
            teacherEntity = new TeacherEntity();
        }else{
            Optional<TeacherEntity> teacherEntityOptional = teacherRepository.findById(createTeacherForm.getId());
            teacherEntity = teacherEntityOptional.orElseGet(TeacherEntity::new);
        }

        teacherEntity.setBranch(createTeacherForm.getBranch());
        teacherEntity.setName(createTeacherForm.getName());
        teacherEntity.setPassword(createTeacherForm.getPassword());
        teacherEntity.setUserName(createTeacherForm.getUserName());

        teacherRepository.save(teacherEntity);
    }

    public void updateTeacher(CreateTeacherForm createTeacherForm)
    {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setBranch(createTeacherForm.getBranch());
        teacherEntity.setName(createTeacherForm.getName());
        teacherEntity.setPassword(createTeacherForm.getPassword());
        teacherEntity.setUserName(createTeacherForm.getUserName());

        teacherRepository.save(teacherEntity);
    }


    public void deleteTeacher(Long id)
    {
        Optional<TeacherEntity> teacherEntityOptional = teacherRepository.findById(id);
        teacherEntityOptional.ifPresent(teacherEntity -> teacherRepository.delete(teacherEntity));
    }
}
