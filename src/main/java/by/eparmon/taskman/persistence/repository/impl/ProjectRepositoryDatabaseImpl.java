package by.eparmon.taskman.persistence.repository.impl;

import by.eparmon.taskman.persistence.model.Project;
import by.eparmon.taskman.persistence.repository.ProjectRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("prod")
public class ProjectRepositoryDatabaseImpl implements ProjectRepository {

    @Override
    public Optional<Project> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Project save(Project project) {
        return null;
    }
}
