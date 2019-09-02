package by.eparmon.taskman.persistence.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Project {

    @Id
    private Long id;
    private String name;
    private LocalDate createdAt;
}
