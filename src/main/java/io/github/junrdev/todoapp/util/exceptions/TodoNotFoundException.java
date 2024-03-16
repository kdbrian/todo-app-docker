package io.github.junrdev.todoapp.util.exceptions;

public class TodoNotFoundException extends Exception{
    public TodoNotFoundException(String message) {
        super(String.format("Todo with id %s not found", message));
    }
}
