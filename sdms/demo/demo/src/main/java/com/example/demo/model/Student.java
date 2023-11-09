package com.example.demo.model;

import com.example.demo.dto.StudentDto;
import lombok.Data;
import javax.persistence.*;


@Entity
@Table(name = "Students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIG SERIAL")
    private long id;
    @Column(name = "deleted")
    private boolean deleted;
    @Column(name = "std_fst_name")
    private String stdFirstName;
    @Column(name = "std_last_name")
    private String stdLastName;
    @Column(name = "std_no")
    private String stdNo;
    @Column(name = "std_age")
    private long stdAge;

    public Student(StudentDto studentDto) {
        this.stdFirstName = studentDto.getStdFirstName();
        this.stdLastName = studentDto.getStdLastName();
        this.stdNo = studentDto.getStdNo();
        this.stdAge = studentDto.getStdAge();
    }



}

