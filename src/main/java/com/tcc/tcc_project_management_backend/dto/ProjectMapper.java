package com.tcc.tcc_project_management_backend.dto;

import com.tcc.tcc_project_management_backend.model.Project;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProjectMapper {

    private final TaskMapper taskMapper;

    public ProjectMapper(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public ProjectDTO toDTO(Project project) {
        ProjectDTO dto = new ProjectDTO();

        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setStatus(project.getStatus());
        dto.setStartDate(project.getStartDate());
        dto.setEndDate(project.getEndDate());

        if (project.getTasks() != null) {
            dto.setTasks(
                    project.getTasks().stream()
                            .map(taskMapper::toDTO)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

    public Project toEntity(CreateProjectDTO dto) {
        Project project = new Project();

        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStatus(dto.getStatus());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());

        return project;
    }

    public void updateEntity(Project project, UpdateProjectDTO dto) {
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStatus(dto.getStatus());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());
    }
}
