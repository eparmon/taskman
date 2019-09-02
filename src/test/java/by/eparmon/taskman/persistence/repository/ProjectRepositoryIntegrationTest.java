package by.eparmon.taskman.persistence.repository;

import by.eparmon.taskman.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class ProjectRepositoryIntegrationTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void save() {
        Project project = new Project(1L, "Project", LocalDate.now());
        assertThat(projectRepository.save(project), is(notNullValue()));
    }

    @Test
    public void findById() {
        Project project = new Project(1L, "Project", LocalDate.now());
        projectRepository.save(project);
        Optional<Project> retrievedProject = projectRepository.findById(project.getId());
        //noinspection OptionalGetWithoutIsPresent
        assertThat(retrievedProject.get(), is(equalTo(project)));
    }
}
