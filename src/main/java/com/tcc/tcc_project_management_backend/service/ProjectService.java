package com.tcc.tcc_project_management_backend.service;

import com.tcc.tcc_project_management_backend.model.Project;
import java.util.List;

public interface ProjectService {

    Project createProject(Project project);

    Project updateProject(Long id, Project project);

    void deleteProject(Long id);

    Project getProjectById(Long id);

    List<Project> getAllProjects();
}
