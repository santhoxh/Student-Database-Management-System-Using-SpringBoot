package com.example.demo.services;

import com.example.demo.dto.StudentDto;


import java.util.List;

public interface StudentService {
    void saveStudent(StudentDto studentDto);
    StudentDto getStudentById(long Id);
    void updateStudent(Long id,StudentDto studentDto);
    void deleteStudent(Long id);
    List<StudentDto> getAllStudentById();


}
