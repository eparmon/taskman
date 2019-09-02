package by.eparmon.taskman.persistence.repository;

import by.eparmon.taskman.persistence.model.Project;
import org.springframework.data.repository.CrudRepository;


public interface ProjectRepository extends CrudRepository<Project, Long> {

}
