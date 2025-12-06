package com.tcc.tcc_project_management_backend.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("Task with ID " + id + " was not found");
    }
}
