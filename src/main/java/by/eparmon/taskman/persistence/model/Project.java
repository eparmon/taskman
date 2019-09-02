package by.eparmon.taskman.persistence.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Project {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate createdAt;

    @OneToMany
    @JoinColumn(name = "project_id")
    @EqualsAndHashCode.Exclude
    private List<Task> tasks;
}
