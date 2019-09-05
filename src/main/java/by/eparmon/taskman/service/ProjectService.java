package by.eparmon.taskman.service;

import by.eparmon.taskman.persistence.model.Project;

import java.util.Optional;

public interface ProjectService {

    Optional<Project> findById(Long id);

    Iterable<Project> findAll();

    Project save(Project project);
}
