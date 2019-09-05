package by.eparmon.taskman.web.controller;

import by.eparmon.taskman.persistence.model.Project;
import by.eparmon.taskman.persistence.repository.ProjectRepository;
import by.eparmon.taskman.web.dto.ProjectDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(webEnvironment = DEFINED_PORT)
@ActiveProfiles("rest")
public class ProjectControllerIntegrationTest {

    private static final String BASE_URL = "http://localhost:8090/projects";

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void getProject() {
        Project project = projectRepository.findByName("Old Project")
                .orElseThrow(RuntimeException::new);
        ResponseEntity<ProjectDto> response = restTemplate.getForEntity(BASE_URL + "/" + project.getId(),
                ProjectDto.class);
        assertThat(response.getStatusCodeValue(), equalTo(HttpStatus.OK.value()));
        assertNotNull(response.getBody());
    }
}
