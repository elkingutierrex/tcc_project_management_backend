package com.tcc.tcc_project_management_backend.service;

import com.tcc.tcc_project_management_backend.dto.CreateProjectDTO;
import com.tcc.tcc_project_management_backend.dto.ProjectDTO;
import com.tcc.tcc_project_management_backend.dto.UpdateProjectDTO;

import java.util.List;

public interface ProjectService {

    ProjectDTO createProject(CreateProjectDTO dto);

    ProjectDTO updateProject(Long id, UpdateProjectDTO dto);

    void deleteProject(Long id);

    ProjectDTO getProjectById(Long id);

    List<ProjectDTO> getAllProjects();
}
