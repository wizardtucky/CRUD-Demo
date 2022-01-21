package com.example.demo.student.services;

import com.example.demo.student.mappers.StudentMapper;
import com.example.demo.student.model.CreateStudentDto;
import com.example.demo.student.model.Student;
import com.example.demo.student.model.StudentDto;
import com.example.demo.student.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentDto createStudent(CreateStudentDto createStudentDto){
        Student newStudent = StudentMapper.toStudent(createStudentDto);
        studentRepository.save(newStudent);
        return StudentMapper.toStudentDto(newStudent);
    }

    public Student getStudentDto(Long id){
        Optional<Student> student = studentRepository.findById(id);
        student.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found by id " + id));
        return student.get();
    }

    public List<StudentDto> getAllStudentDto() {
        return studentRepository
                .findAll()
                .stream()
                .map(StudentMapper::toStudentDto)
                .collect(Collectors.toList());
    }

    public void deleteStudent(Long id){
        studentRepository.delete(getStudentDto(id));
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
        //Optional<Student> originalStudentInfo = Optional.ofNullable(studentRepository.findById(student.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found on :: " + student.getId())));

        // exist in the items object - yes - update, no - create/add

    }

}
