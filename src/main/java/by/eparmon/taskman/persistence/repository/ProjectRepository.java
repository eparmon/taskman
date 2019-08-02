package by.eparmon.taskman.persistence.repository;

import by.eparmon.taskman.persistence.model.Project;

import java.util.Optional;

public interface ProjectRepository {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
