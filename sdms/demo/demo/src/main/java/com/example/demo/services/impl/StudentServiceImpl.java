package com.example.demo.services.impl;

import com.example.demo.dao.StudentDoa;
import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDoa studentDoa;

    @Override
    public void saveStudent(StudentDto studentDto){
        try{
            Student student= new Student(studentDto);
            studentDoa.save(student);

        }
        catch (Exception e){
            throw e;
        }
    }


    @Override
    public StudentDto getStudentById(long id) {
        StudentDto studentDto=null;
        try{
            Student student=studentDoa.getById(id);
            studentDto= new StudentDto(student);
        }catch (Exception e){
            throw e;
        }
        return studentDto;
    }

    @Override
    public void updateStudent(Long id, StudentDto studentDto){
        try{
            Student student= studentDoa.getById(id);
            student=mapStudentDetails(student, studentDto);
            studentDoa.save(student);
        }catch (Exception e){
            throw e;
        }
    }

    private Student mapStudentDetails(Student student, StudentDto studentDto) {

        try{
            student.setId(studentDto.getId());
            student.setStdFirstName(studentDto.getStdFirstName());
            student.setStdLastName(studentDto.getStdLastName());
            student.setStdNo(studentDto.getStdNo());
            student.setStdAge(studentDto.getStdAge());
        }
        catch (Exception e){

        }
        return student;
    }



    @Override
    public void deleteStudent(Long id){
        try{
            Student student=studentDoa.getById(id);
            student.setDeleted(true);
            studentDoa.save(student);
        }catch (Exception e){
            throw e;
        }

    }
    @Override
    public List<StudentDto> getAllStudentById(){
        List<StudentDto> studentDtoList=new ArrayList<>();
        try{
            List<Student> studentList= studentDoa.findByDeletedFalse();
            if(!studentList.isEmpty()){
                studentList.forEach(student ->{
                    StudentDto studentDto=new StudentDto(student);
                    studentDtoList.add(studentDto);
                });
            }
        }catch (Exception e){
            throw e;
        }
        return studentDtoList;
    }
}
