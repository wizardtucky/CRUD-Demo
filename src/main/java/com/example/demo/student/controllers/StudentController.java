package com.example.demo.student.controllers;

import com.example.demo.student.services.StudentService;
import com.example.demo.student.model.CreateStudentDto;
import com.example.demo.student.model.Student;
import com.example.demo.student.model.StudentDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/student")
@Tag(name="Student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public StudentDto createStudent(@RequestBody CreateStudentDto student) {
        return studentService.createStudent(student);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getById")
    public Student getStudent(long id){ return studentService.getStudentDto(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAll")
    public List<StudentDto> getAllStudent(){ return studentService.getAllStudentDto();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStudent(long id) { studentService.deleteStudent(id);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }
}
