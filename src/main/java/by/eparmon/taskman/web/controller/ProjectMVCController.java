package by.eparmon.taskman.web.controller;

import by.eparmon.taskman.service.ProjectService;
import by.eparmon.taskman.web.converter.ProjectConverter;
import by.eparmon.taskman.web.dto.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/projects")
@Profile("mvc")
@RequiredArgsConstructor
public class ProjectMVCController {

    private final ProjectService projectService;

    @GetMapping
    public String getProjects(Model model) {
        List<ProjectDto> projects = new ArrayList<>();
        projectService.findAll().forEach(project -> projects.add(ProjectConverter.convertToDto(project)));
        model.addAttribute("projects", projects);
        return "projects";
    }
}
