package com.tcc.tcc_project_management_backend.dto;

import com.tcc.tcc_project_management_backend.model.TaskStatus;
import java.time.LocalDate;

public class UpdateTaskDTO {

    private String title;
    private String description;
    private TaskStatus status;
    private LocalDate dueDate;

    // getters + setters
}
