package by.eparmon.taskman.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProjectCreatedEvent {

    private Long projectId;
}
