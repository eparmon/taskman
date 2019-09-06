package by.eparmon.taskman.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProjectCreatedListener {

    @EventListener
    public void handle(ProjectCreatedEvent event) {
        log.info("New Project created with id={}", event.getProjectId());
    }
}
