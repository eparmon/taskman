package by.eparmon.taskman.web.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
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
    private LocalDate createdAt;
    private List<TaskDto> tasks = new ArrayList<>();
}
