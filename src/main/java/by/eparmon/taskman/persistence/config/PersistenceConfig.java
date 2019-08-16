package by.eparmon.taskman.persistence.config;

import by.eparmon.taskman.persistence.repository.ProjectRepository;
import by.eparmon.taskman.persistence.repository.impl.ProjectRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfig {

    @Bean
    public ProjectRepository projectRepository() {
        return new ProjectRepositoryImpl();
    }
}
