package by.eparmon.taskman.persistence.service;

import by.eparmon.taskman.persistence.model.Project;

import java.util.Optional;

public interface ProjectService {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
