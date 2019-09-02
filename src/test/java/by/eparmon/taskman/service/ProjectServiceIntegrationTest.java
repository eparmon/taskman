package by.eparmon.taskman.service;

import by.eparmon.taskman.config.TestConfig;
import by.eparmon.taskman.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@ActiveProfiles("dev")
@SpringJUnitConfig(classes = TestConfig.class)
public class ProjectServiceIntegrationTest {

    @Autowired
    private ProjectService projectService;

    @Test
    public void save() {
        projectService.save(new Project());
    }
}
