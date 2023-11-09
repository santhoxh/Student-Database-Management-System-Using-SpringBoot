package com.example.demo.Controller;
import com.example.demo.services.StudentService;
import com.example.demo.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/test")
    public String HelloWorld() {
        String test = "hello world";
        return test;
    }

    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentDto studentDto) {
        try {
            studentService.saveStudent(studentDto);
        } catch (Exception e) {
            throw e;
        }
        return "student saved successfully";
    }

    @GetMapping("/get/{id}")
    public StudentDto GetStudentById(@PathVariable(value = "id") Long id) {
        StudentDto studentDto = studentService.getStudentById(id);
        try {
            studentDto = studentService.getStudentById(id);
        } catch (Exception e) {
            throw e;
        }
        return studentDto;
    }
    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable(value = "id")Long id,@RequestBody StudentDto studentDto){
        try{
            studentService.updateStudent(id,studentDto);
        }catch (Exception e){
            throw e;
        }
        return "student details updated successfully";
    }
    public String deleteStudent(@PathVariable(value = "id") Long id) {
        try {
            studentService.deleteStudent(id);
            return "Student deleted successfully";
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/getAll")
    public List<StudentDto> getAllStudentById(){
        List<StudentDto> studentDto=new ArrayList<>();
        try{
            studentDto= studentService.getAllStudentById();
        }catch (Exception e){
            throw e;
        }
        return studentDto;
    }
}

