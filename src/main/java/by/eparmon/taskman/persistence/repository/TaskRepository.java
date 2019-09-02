package by.eparmon.taskman.persistence.repository;

import by.eparmon.taskman.persistence.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    @Query("select t from Task t where t.name like %:string%")
    List<Task> findByNameLike(@Param("string") String string);
}
