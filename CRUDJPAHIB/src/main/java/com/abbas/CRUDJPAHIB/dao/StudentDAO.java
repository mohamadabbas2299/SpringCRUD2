package com.abbas.CRUDJPAHIB.dao;

import com.abbas.CRUDJPAHIB.entity.Student;

import java.util.List;


public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLstName(String theLastName);

    void update(Student studentDAO);

    void delete(Integer id);

    int deleteall();
}
