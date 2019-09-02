package by.eparmon.taskman.service;

import by.eparmon.taskman.config.TestConfig;
import by.eparmon.taskman.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringJUnitConfig(classes = TestConfig.class)
public class ProjectServiceIntegrationTest {

    @Autowired
    private ProjectService projectService;

    @Test
    public void save() {
        projectService.save(new Project(1L, "Lorem ipsum", LocalDate.now()));
    }
}
