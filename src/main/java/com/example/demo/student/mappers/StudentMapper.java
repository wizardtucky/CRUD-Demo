package com.example.demo.student.mappers;

import com.example.demo.student.model.CreateStudentDto;
import com.example.demo.student.model.Student;
import com.example.demo.student.model.StudentDto;

public class StudentMapper {

    public static Student toStudent(CreateStudentDto createUserDto){ // siuntimas i serveri
        return Student.builder()
                .name(createUserDto.getName())
                .age(createUserDto.getAge())
                .president(createUserDto.getPresident())
                .build();
    }

    public static StudentDto toStudentDto(Student student){ // get by id(is serverio)
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .age(student.getAge())
                .president(student.getPresident())
                .build();
    }
}
