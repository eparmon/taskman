package by.eparmon.taskman.web.dto;

import by.eparmon.taskman.persistence.model.Task;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    private Long id;
    private String name;
    private List<Task> tasks;
}
