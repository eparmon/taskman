package by.eparmon.taskman.config;

import by.eparmon.taskman.persistence.model.Project;
import by.eparmon.taskman.persistence.repository.ProjectRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TestDataLoader implements ApplicationContextAware {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        projectRepository.save(Project.builder()
                .name("Old Project")
                .createdAt(LocalDate.now().minusYears(1))
                .build());
        projectRepository.save(Project.builder()
                .name("Project 3")
                .createdAt(LocalDate.now())
                .build());
        projectRepository.save(Project.builder()
                .name("Project 2")
                .createdAt(LocalDate.now())
                .build());
        projectRepository.save(Project.builder()
                .name("Project 4")
                .createdAt(LocalDate.now())
                .build());
    }
}
