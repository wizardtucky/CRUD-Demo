package com.example.demo.student.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePresidentDto {
    private String name;
    private Integer age;
}
