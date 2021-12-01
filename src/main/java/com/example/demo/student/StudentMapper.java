package com.example.demo.student;

import com.example.demo.student.model.CreateStudentDto;
import com.example.demo.student.model.Student;
import com.example.demo.student.model.StudentDto;

public class StudentMapper {

    public static Student toStudent(CreateStudentDto createUserDto){ // siuntimas i serveri
        return Student.builder()
                .name(createUserDto.getName())
                .age(createUserDto.getAge())
                .build();
    }

    public static StudentDto toStudentDto(Student student){ // get by id(is serverio)
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .age(student.getAge())
                .build();
    }
}
