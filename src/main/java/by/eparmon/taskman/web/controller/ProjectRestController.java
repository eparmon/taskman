package by.eparmon.taskman.web.controller;

import by.eparmon.taskman.service.ProjectService;
import by.eparmon.taskman.web.converter.ProjectConverter;
import by.eparmon.taskman.web.dto.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/projects")
@Profile("rest")
@RequiredArgsConstructor
public class ProjectRestController {

    private final ProjectService projectService;

    @GetMapping("/{id}")
    public ProjectDto findOne(@PathVariable Long id) {
        return ProjectConverter.convertToDto(projectService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @PostMapping
    public void create(@RequestBody ProjectDto projectDto) {
        projectService.save(ProjectConverter.convertToEntity(projectDto));
    }
}
