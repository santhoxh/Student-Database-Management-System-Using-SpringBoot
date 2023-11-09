package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
public interface StudentDoa extends JpaRepository<Student, Long> {
    @Query("SELECT std from student std where std.deleted=false")
    List<Student> getAllStudent();

    List<Student> findByDeletedFalse();
}
