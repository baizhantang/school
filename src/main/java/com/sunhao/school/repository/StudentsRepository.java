package com.sunhao.school.repository;

import com.sunhao.school.been.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Integer> {

    @Query("select student.name, student.gender, student.weight, classes.name, grades.name " +
            "from Students student left join student.classes classes left join classes.grades grades " +
            "where grades.name=?1 " +
            "and classes.name=?2 " +
            "and student.name=?3")
    List<Object> cascadeQuery(String gradeName, String className, String studentName);

    @Query("select student.name, student.gender, student.weight, classes.name, grades.name " +
            "from Students student left join student.classes classes left join classes.grades grades " +
            "where student.classes.id=classes.id " +
            "and classes.grades.id=grades.id")
    List<Object> findAllStudents();
}
