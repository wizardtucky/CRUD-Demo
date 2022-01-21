package com.example.demo.student.mappers;

import com.example.demo.student.model.*;

public class PresidentMapper {
    public static President toPresident(CreatePresidentDto createUserDto){ // siuntimas i serveri
        return President.builder()
                .name(createUserDto.getName())
                .age(createUserDto.getAge())
                .build();
    }

    public static PresidentDto toPresidentDto(President president){ // get by id(is serverio)
        return PresidentDto.builder()
                .id(president.getId())
                .name(president.getName())
                .age(president.getAge())
                .build();
    }
}
