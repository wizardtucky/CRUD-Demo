package com.example.demo.student.services;


import com.example.demo.student.mappers.PresidentMapper;
import com.example.demo.student.mappers.StudentMapper;
import com.example.demo.student.model.CreatePresidentDto;
import com.example.demo.student.model.President;
import com.example.demo.student.model.PresidentDto;
import com.example.demo.student.repositories.ClassPresidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PresidentService {

    private final ClassPresidentRepository presidentRepository;

    public PresidentDto createPresident(CreatePresidentDto createPresidentDto){
        President newPresident = PresidentMapper.toPresident(createPresidentDto);
        presidentRepository.save(newPresident);
        return PresidentMapper.toPresidentDto(newPresident);
    }

    public President getPresidentDto(Long id){
        Optional<President> president = presidentRepository.findById(id);
        president.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "president not found by id " + id));
        return president.get();
    }

    public List<PresidentDto> getAllPresidentDto() {
        return presidentRepository
                .findAll()
                .stream()
                .map(PresidentMapper::toPresidentDto)
                .collect(Collectors.toList());
    }

    public void deletePresident(Long id){
        presidentRepository.delete(getPresidentDto(id));
    }

    public void updatePresident(President president) {
        presidentRepository.save(president);
        //Optional<President> originalPresidentInfo = Optional.ofNullable(presidentRepository.findById(president.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found on :: " + president.getId())));

        // exist in the items object - yes - update, no - create/add

    }

}
