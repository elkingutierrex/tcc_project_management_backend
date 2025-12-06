package com.tcc.tcc_project_management_backend.dto;

import com.tcc.tcc_project_management_backend.model.ProjectStatus;
import java.time.LocalDate;

public class UpdateProjectDTO {

    private String name;
    private String description;
    private ProjectStatus status;
    private LocalDate startDate;
    private LocalDate endDate;

    // Same getters/setters as CreateProjectDTO
}
