package by.eparmon.taskman.persistence.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Project {

    private Long id;
    private String name;
    private LocalDate createdAt;
}
