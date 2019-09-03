package by.eparmon.taskman.web.controller;

import by.eparmon.taskman.persistence.model.Project;
import by.eparmon.taskman.service.ProjectService;
import by.eparmon.taskman.web.dto.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/{id}")
    public ProjectDto findOne(@PathVariable Long id) {
        return convertToDto(projectService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @PostMapping
    public void create(@RequestBody ProjectDto projectDto) {
        projectService.save(convertToEntity(projectDto));
    }

    private ProjectDto convertToDto(Project project) {
        return ProjectDto.builder()
                .id(project.getId())
                .name(project.getName())
                .tasks(project.getTasks())
                .build();
    }

    private Project convertToEntity(ProjectDto projectDto) {
        return Project.builder()
                .id(projectDto.getId())
                .name(projectDto.getName())
                .tasks(projectDto.getTasks())
                .build();
    }
}
