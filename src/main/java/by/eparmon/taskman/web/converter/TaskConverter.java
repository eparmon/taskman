package by.eparmon.taskman.web.converter;

import by.eparmon.taskman.persistence.model.Task;
import by.eparmon.taskman.web.dto.TaskDto;

public class TaskConverter {

    public static TaskDto convertToDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .createdAt(task.getCreatedAt())
                .dueDate(task.getDueDate())
                .status(task.getStatus())
                .build();
    }

    public static Task convertToEntity(TaskDto taskDto) {
        return Task.builder()
                .id(taskDto.getId())
                .name(taskDto.getName())
                .description(taskDto.getDescription())
                .createdAt(taskDto.getCreatedAt())
                .dueDate(taskDto.getDueDate())
                .status(taskDto.getStatus())
                .build();
    }
}
