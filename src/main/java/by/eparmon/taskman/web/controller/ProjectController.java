package by.eparmon.taskman.web.controller;

import by.eparmon.taskman.persistence.model.Project;
import by.eparmon.taskman.service.ProjectService;
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
    public Project findOne(@PathVariable Long id) {
        return projectService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public void create(@RequestBody Project project) {
        projectService.save(project);
    }
}
