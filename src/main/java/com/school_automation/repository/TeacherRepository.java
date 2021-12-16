package com.school_automation.repository;

import com.school_automation.entity.TeacherEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<TeacherEntity, Long> {

    TeacherEntity findTeacherEntityByUserName(String userName);
}
