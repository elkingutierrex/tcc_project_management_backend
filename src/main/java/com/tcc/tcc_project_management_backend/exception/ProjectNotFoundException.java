package com.tcc.tcc_project_management_backend.exception;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(Long id) {
        super("Project with ID " + id + " was not found");
    }
}
