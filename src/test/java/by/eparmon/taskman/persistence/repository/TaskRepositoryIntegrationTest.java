package by.eparmon.taskman.persistence.repository;

import by.eparmon.taskman.persistence.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class TaskRepositoryIntegrationTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void findByNameLike() {
        Task task1 = taskRepository.save(Task.builder()
                .name("Some task")
                .createdAt(LocalDate.now())
                .dueDate(LocalDate.now().plusDays(1))
                .build());
        Task task2 = taskRepository.save(Task.builder()
                .name("Task for Johnny")
                .createdAt(LocalDate.now())
                .dueDate(LocalDate.now().plusDays(1))
                .build());
        Task task3 = taskRepository.save(Task.builder()
                .name("A bug")
                .createdAt(LocalDate.now())
                .dueDate(LocalDate.now().plusDays(1))
                .build());
        List<Task> retrievedTasks = taskRepository.findByNameLike("ask");
        assertThat(retrievedTasks.size(), equalTo(2));
        assertThat(retrievedTasks, hasItems(task1, task2));
    }
}
