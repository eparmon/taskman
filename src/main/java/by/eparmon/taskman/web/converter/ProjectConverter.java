package by.eparmon.taskman.web.converter;

import by.eparmon.taskman.persistence.model.Project;
import by.eparmon.taskman.web.dto.ProjectDto;

import java.util.stream.Collectors;

public class ProjectConverter {

    public static ProjectDto convertToDto(Project project) {
        return ProjectDto.builder()
                .id(project.getId())
                .name(project.getName())
                .createdAt(project.getCreatedAt())
                .tasks(project.getTasks().stream()
                        .map(TaskConverter::convertToDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public static Project convertToEntity(ProjectDto projectDto) {
        return Project.builder()
                .id(projectDto.getId())
                .name(projectDto.getName())
                .createdAt(projectDto.getCreatedAt())
                .tasks(projectDto.getTasks().stream()
                        .map(TaskConverter::convertToEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
