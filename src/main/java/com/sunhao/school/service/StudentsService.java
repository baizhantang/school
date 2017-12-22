package com.sunhao.school.service;

import com.sunhao.school.been.Students;
import com.sunhao.school.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;

    public List<Map<String, Object>> getResultsByNames(String gradeName, String className, String studentName) {
        List<Map<String, Object>> finalResult = new ArrayList<>();
        Map<String,Object> queResult = new HashMap<>();
        String[] arrayStr = {"name", "gender", "weight", "className", "gradeName"};
        int i;

        List<Object> result = studentsRepository.cascadeQuery(gradeName, className, studentName);
        for(Object code:result){
            JSONArray vals = (JSONArray)JSON.toJSON(code);
            i = 0;

            //把数据和字段名关联
            queResult.put(arrayStr[i++],vals.getString(0));
            queResult.put(arrayStr[i++],vals.getString(1));
            queResult.put(arrayStr[i++],vals.getDouble(2));
            queResult.put(arrayStr[i++],vals.getString(3));
            queResult.put(arrayStr[i],vals.getString(4));
            finalResult.add(queResult);
        }
        return finalResult;
    }

    public List<Map<String, Object>> getAllData(){
        List<Map<String, Object>> finalResult = new ArrayList<>();
        Map<String,Object> queResult = new HashMap<>();
        String[] arrayStr = {"name", "gender", "weight", "className", "gradeName"};
        int i;

        List<Object> result = studentsRepository.findAllStudents();
        for(Object code:result){
            JSONArray vals = (JSONArray)JSON.toJSON(code);
            i = 0;

            System.out.println(vals);
            //把数据和字段名关联
            queResult.put(arrayStr[i++],vals.getString(0));
            queResult.put(arrayStr[i++],vals.getString(1));
            queResult.put(arrayStr[i++],vals.getDouble(2));
            queResult.put(arrayStr[i++],vals.getString(3));
            queResult.put(arrayStr[i],vals.getString(4));
            System.out.println(queResult);
            finalResult.add(queResult);
        }
        return finalResult;
    }


}
