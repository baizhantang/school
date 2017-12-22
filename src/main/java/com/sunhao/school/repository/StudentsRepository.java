package com.sunhao.school.repository;

import com.sunhao.school.been.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Integer> {

//    student.name, student.gender, student.weight, classes.name, grades.name
    @Query("select student.name, student.gender, student.weight, classes.name, grades.name " +
            "from Students student left join student.classes classes left join classes.grades grades " +
            "where grades.name=?1 " +
            "and classes.name=?2 " +
            "and student.name=?3")
    public List<Students> cascadeQuery(String gradeName, String className, String studentName);
}
