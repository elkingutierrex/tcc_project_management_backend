package com.tcc.tcc_project_management_backend.service.impl;

import com.tcc.tcc_project_management_backend.dto.CreateProjectDTO;
import com.tcc.tcc_project_management_backend.dto.ProjectDTO;
import com.tcc.tcc_project_management_backend.dto.ProjectMapper;
import com.tcc.tcc_project_management_backend.dto.UpdateProjectDTO;
import com.tcc.tcc_project_management_backend.exception.ProjectNotFoundException;
import com.tcc.tcc_project_management_backend.model.Project;
import com.tcc.tcc_project_management_backend.repository.ProjectRepository;
import com.tcc.tcc_project_management_backend.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public ProjectDTO createProject(CreateProjectDTO dto) {
        Project project = projectMapper.toEntity(dto);
        Project saved = projectRepository.save(project);
        return projectMapper.toDTO(saved);
    }

    @Override
    public ProjectDTO updateProject(Long id, UpdateProjectDTO dto) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));

        projectMapper.updateEntity(project, dto);

        Project saved = projectRepository.save(project);
        return projectMapper.toDTO(saved);
    }

    @Override
    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new ProjectNotFoundException(id);
        }
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));

        return projectMapper.toDTO(project);
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::toDTO)
                .toList();
    }
}
