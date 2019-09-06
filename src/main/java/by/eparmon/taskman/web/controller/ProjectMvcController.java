package by.eparmon.taskman.web.controller;

import by.eparmon.taskman.event.ProjectCreatedEvent;
import by.eparmon.taskman.persistence.model.Project;
import by.eparmon.taskman.service.ProjectService;
import by.eparmon.taskman.web.converter.ProjectConverter;
import by.eparmon.taskman.web.dto.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/projects")
@Profile("mvc")
@RequiredArgsConstructor
public class ProjectMvcController {

    private final ProjectService projectService;
    private final ApplicationEventPublisher eventPublisher;

    @GetMapping
    public String getProjects(Model model) {
        List<ProjectDto> projects = new ArrayList<>();
        projectService.findAll().forEach(project -> projects.add(ProjectConverter.convertToDto(project)));
        model.addAttribute("projects", projects);
        return "projects";
    }

    @GetMapping("/{id}")
    public ProjectDto findOne(@PathVariable Long id) {
        return ProjectConverter.convertToDto(projectService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }


    @GetMapping("/new")
    public String newProject(Model model) {
        model.addAttribute("project", new ProjectDto());
        return "new-project";
    }

    @PostMapping
    public String addProject(@Valid @ModelAttribute("project") ProjectDto projectDto, BindingResult bindingResult) {
        Project project = projectService.save(ProjectConverter.convertToEntity(projectDto));
        if (bindingResult.hasErrors())
            return "new-project";
        eventPublisher.publishEvent(new ProjectCreatedEvent(project.getId()));
        return "redirect:/projects";
    }

}
