package by.eparmon.taskman.service;

import by.eparmon.taskman.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class ProjectServiceIntegrationTest {

    @Autowired
    private ProjectService projectService;

    @Test
    public void save() {
        projectService.save(Project.builder()
                .name("Lorem ipsum")
                .createdAt(LocalDate.now())
                .build());
    }
}
