package by.eparmon.taskman.persistence.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder(toBuilder = true)
@EqualsAndHashCode
public class Project {

    private Long id;
    private String name;
    private LocalDate createdAt;
}
