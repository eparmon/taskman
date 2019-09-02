package by.eparmon.taskman.persistence.repository;

import by.eparmon.taskman.persistence.model.Project;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class ProjectRepositoryIntegrationTest {

    @Autowired
    private ProjectRepository projectRepository;

    @AfterEach
    public void tearDown() {
        projectRepository.deleteAll();
    }

    @Test
    public void save() {
        Project project = projectRepository.save(Project.builder()
                .name("Project")
                .createdAt(LocalDate.now())
                .build());
        assertThat(projectRepository.save(project), is(notNullValue()));
    }

    @Test
    public void findById() {
        Project project = projectRepository.save(Project.builder()
                .name("Project")
                .createdAt(LocalDate.now())
                .build());
        Optional<Project> retrievedProject = projectRepository.findById(project.getId());
        //noinspection OptionalGetWithoutIsPresent
        assertThat(retrievedProject.get(), is(equalTo(project)));
    }

    @Test
    public void findByName() {
        Project project = projectRepository.save(Project.builder()
                .name("Project")
                .createdAt(LocalDate.now())
                .build());
        Optional<Project> retrievedProject = projectRepository.findByName(project.getName());
        //noinspection OptionalGetWithoutIsPresent
        assertThat(retrievedProject.get(), is(equalTo(project)));
    }

    @Test
    public void findByCreatedAtBetween() {
        Project oldProject = projectRepository.save(Project.builder()
                .name("Project")
                .createdAt(LocalDate.now().minusYears(1))
                .build());
        Project newProject1 = projectRepository.save(Project.builder()
                .name("Project")
                .createdAt(LocalDate.now())
                .build());
        Project newProject2 = projectRepository.save(Project.builder()
                .name("Project")
                .createdAt(LocalDate.now())
                .build());
        List<Project> newProjects = projectRepository.findByCreatedAtBetween(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(1));
        assertThat(newProjects.size(), equalTo(2));
        assertThat(newProjects, hasItems(newProject1, newProject2));
    }
}
