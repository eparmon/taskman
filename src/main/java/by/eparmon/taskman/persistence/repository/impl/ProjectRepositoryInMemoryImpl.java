package by.eparmon.taskman.persistence.repository.impl;

import by.eparmon.taskman.persistence.model.Project;
import by.eparmon.taskman.persistence.repository.ProjectRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("dev")
public class ProjectRepositoryInMemoryImpl implements ProjectRepository {

    private List<Project> projects = new ArrayList<>();

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream()
                .filter(project -> project.getId().equals(id))
                .findFirst();
    }

    @Override
    public Project save(Project project) {
        findById(project.getId())
                .ifPresent(existingProject -> projects.remove(existingProject));
        projects.add(project.toBuilder().build());
        return project;
    }
}

