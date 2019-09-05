package by.eparmon.taskman.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private LocalDate createdAt;
    private LocalDate dueDate;
    private TaskStatus status;
}
