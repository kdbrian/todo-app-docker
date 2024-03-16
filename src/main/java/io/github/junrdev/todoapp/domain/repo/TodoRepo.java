package io.github.junrdev.todoapp.domain.repo;

import io.github.junrdev.todoapp.domain.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {

    List<Todo> findTodoByStatus(Boolean status);

}
