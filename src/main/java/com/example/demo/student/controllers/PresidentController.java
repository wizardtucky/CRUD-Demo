package com.example.demo.student.controllers;

import com.example.demo.student.model.CreatePresidentDto;
import com.example.demo.student.model.President;
import com.example.demo.student.model.PresidentDto;
import com.example.demo.student.services.PresidentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/president")
@Tag(name="President")
public class PresidentController {
    private final PresidentService presidentService;

    @PostMapping
    public PresidentDto createPresident(@RequestBody CreatePresidentDto president) {
        return presidentService.createPresident(president);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getById")
    public President getPresident(long id){ return presidentService.getPresidentDto(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAll")
    public List<PresidentDto> getAllPresident(){ return presidentService.getAllPresidentDto();
    }

    @DeleteMapping(path = "/{id}")
    public void deletePresident(long id) { presidentService.deletePresident(id);
    }

    @PutMapping
    public void updatePresident(@RequestBody President president){
        presidentService.updatePresident(president);
    }
}
