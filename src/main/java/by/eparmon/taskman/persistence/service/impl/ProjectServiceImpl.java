package by.eparmon.taskman.persistence.service.impl;

import by.eparmon.taskman.persistence.model.Project;
import by.eparmon.taskman.persistence.repository.ProjectRepository;
import by.eparmon.taskman.persistence.service.ProjectService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }
}
