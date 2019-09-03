package by.eparmon.taskman.persistence.repository;

import by.eparmon.taskman.persistence.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

    Optional<Project> findByName(String name);

    List<Project> findByCreatedAtBetween(LocalDate startDate, LocalDate endDate);
}
