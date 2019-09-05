package by.eparmon.taskman.persistence.repository;

import by.eparmon.taskman.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
public class ProjectRepositoryIntegrationTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void save() {
        Project project = projectRepository.save(Project.builder()
                .name("Project")
                .createdAt(LocalDate.now())
                .build());
        assertThat(projectRepository.save(project), is(notNullValue()));

        projectRepository.delete(project);
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

        projectRepository.delete(project);
    }

    @Test
    public void findByName() {
        Optional<Project> retrievedProject = projectRepository.findByName("Old Project");
        assertTrue(retrievedProject.isPresent());

        retrievedProject = projectRepository.findByName("Project 404");
        assertFalse(retrievedProject.isPresent());
    }

    @Test
    public void findByCreatedAtBetween() {
        List<Project> newProjects = projectRepository.findByCreatedAtBetween(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(1));
        assertThat(newProjects, hasSize(3));
    }

    @Test
    public void findAllPaginated() {
        Page<Project> projects = projectRepository.findAll(PageRequest.of(0, 2));
        assertThat(projects.getContent(), hasSize(2));
    }

    @Test
    public void findAllSorted() {
        List<Project> retrievedProjects = new ArrayList<>();
        projectRepository.findAll(Sort.by(Sort.Order.asc("name")))
                .forEach(retrievedProjects::add);
        List<Project> sortedProjects = new ArrayList<>(retrievedProjects);
        sortedProjects.sort(Comparator.comparing(Project::getName));
        assertEquals(sortedProjects, retrievedProjects);
    }

    @Test
    public void findAllPaginatedAndSorted() {
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by(Sort.Order.asc("name")));
        Page<Project> retrievedProjects = projectRepository.findAll(pageRequest);
        assertThat(retrievedProjects.getContent(), hasSize(2));
    }
}
