package by.eparmon.taskman.service.impl;

import by.eparmon.taskman.persistence.model.Project;
import by.eparmon.taskman.persistence.repository.ProjectRepository;
import by.eparmon.taskman.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
