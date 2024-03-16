package io.github.junrdev.todoapp.service;

import io.github.junrdev.todoapp.domain.model.Todo;
import io.github.junrdev.todoapp.domain.repo.TodoRepo;
import io.github.junrdev.todoapp.util.dto.TodoDto;
import io.github.junrdev.todoapp.util.exceptions.TodoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepo todoRepo;


    @Override
    public Todo createTodo(TodoDto dto) {

        var todo = Todo.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .status(dto.getStatus())
                .build();

        return todoRepo.save(todo);
    }

    @Override
    public Todo getTodoById(Long id) throws TodoNotFoundException {

        var opt = todoRepo.findById(id);

        if (opt.isEmpty())
            throw new TodoNotFoundException("" + id);

        return opt.get();
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    @Override
    public List<Todo> getTodosByStatus(Boolean status) {
        return todoRepo.findTodoByStatus(status);
    }

    @Override
    public Todo updateTodo(Todo todo) throws TodoNotFoundException {
        var opt = todoRepo.findById(todo.getId());

        if (opt.isEmpty())
            throw new TodoNotFoundException("" + todo.getId());

        var todo_ = opt.get();

        todo_.setTitle(todo.getTitle());
        todo_.setContent(todo.getContent());
        todo_.setStatus(todo.getStatus());

        return todoRepo.save(todo_);
    }

    @Override
    public void deleteTodo(Todo todo) throws TodoNotFoundException {
        var opt = todoRepo.findById(todo.getId());

        if (opt.isEmpty())
            throw new TodoNotFoundException("" + todo.getId());

        todoRepo.delete(opt.get());
    }
}
