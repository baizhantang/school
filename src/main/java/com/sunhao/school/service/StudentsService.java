package com.sunhao.school.service;

import com.sunhao.school.been.Students;
import com.sunhao.school.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;

    public List<Students> getResultsByNames(String gradeName, String className, String studentName) {
        return studentsRepository.cascadeQuery(gradeName, className, studentName);
    }

    public List<Students> getAllData(){
        return studentsRepository.findAll();
    }


}
