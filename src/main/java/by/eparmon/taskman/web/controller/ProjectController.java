package by.eparmon.taskman.web.controller;

import by.eparmon.taskman.persistence.model.Project;
import by.eparmon.taskman.persistence.model.Task;
import by.eparmon.taskman.service.ProjectService;
import by.eparmon.taskman.web.dto.ProjectDto;
import by.eparmon.taskman.web.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

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
                .tasks(project.getTasks().stream()
                        .map(this::convertToDto)
                        .collect(Collectors.toList()))
                .build();
    }

    private Project convertToEntity(ProjectDto projectDto) {
        return Project.builder()
                .id(projectDto.getId())
                .name(projectDto.getName())
                .tasks(projectDto.getTasks().stream()
                        .map(this::convertToEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    private TaskDto convertToDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .createdAt(task.getCreatedAt())
                .dueDate(task.getDueDate())
                .status(task.getStatus())
                .build();
    }

    private Task convertToEntity(TaskDto taskDto) {
        return Task.builder()
                .id(taskDto.getId())
                .name(taskDto.getName())
                .description(taskDto.getDescription())
                .createdAt(taskDto.getCreatedAt())
                .dueDate(taskDto.getDueDate())
                .status(taskDto.getStatus())
                .build();
    }
}
