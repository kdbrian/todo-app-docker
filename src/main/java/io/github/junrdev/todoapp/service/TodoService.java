package io.github.junrdev.todoapp.service;

import io.github.junrdev.todoapp.domain.model.Todo;
import io.github.junrdev.todoapp.util.dto.TodoDto;
import io.github.junrdev.todoapp.util.exceptions.TodoNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {

    Todo createTodo(TodoDto dto);
    Todo getTodoById(Long id) throws TodoNotFoundException;

    List<Todo> getAllTodos();

    List<Todo> getTodosByStatus(Boolean status);

    Todo updateTodo(Todo todo) throws TodoNotFoundException;

    void deleteTodo(Todo todo) throws TodoNotFoundException;

}
