package com.example.demo.dto;

import com.example.demo.model.Student;
import lombok.Data;


@Data
public class StudentDto {
     long id;
     String stdFirstName;
     String stdLastName;
     String stdNo;
     long stdAge;

     public StudentDto(){

     }

    public StudentDto(Student students){
        this.id=students.getId();
        this.stdFirstName= students.getStdFirstName();
        this.stdLastName=students.getStdLastName();
        this.stdNo=students.getStdNo();
        this.stdAge= students.getStdAge();
    }


}


