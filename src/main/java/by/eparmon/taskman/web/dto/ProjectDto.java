package by.eparmon.taskman.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    private Long id;

    @NotBlank
    private String name;

    private LocalDate createdAt;

    private List<TaskDto> tasks = new ArrayList<>();
}
