package com.sunhao.school.controller;

import com.sunhao.school.been.Students;
import com.sunhao.school.repository.StudentsRepository;
import com.sunhao.school.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@ResponseBody
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @PostMapping(value = "/findAll")
    public List<Map<String, Object>> findAll() {
        return studentsService.getAllData();
    }

    @PostMapping(value = "/findByNames")
    public List<Map<String, Object>> findByNames(@RequestParam("gradeName") String gradeName,
                                      @RequestParam("className") String className,
                                      @RequestParam("studentName") String studentName) {
        return studentsService.getResultsByNames(gradeName, className, studentName);
    }
}
