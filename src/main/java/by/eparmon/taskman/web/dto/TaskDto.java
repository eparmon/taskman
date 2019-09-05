package by.eparmon.taskman.web.dto;

import by.eparmon.taskman.persistence.model.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long id;
    private String name;
    private String description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate createdAt;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dueDate;
    private TaskStatus status;
}
