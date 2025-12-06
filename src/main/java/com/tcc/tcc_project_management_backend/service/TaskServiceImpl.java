package com.tcc.tcc_project_management_backend.service.impl;

import com.tcc.tcc_project_management_backend.dto.CreateTaskDTO;
import com.tcc.tcc_project_management_backend.dto.TaskDTO;
import com.tcc.tcc_project_management_backend.dto.TaskMapper;
import com.tcc.tcc_project_management_backend.dto.UpdateTaskDTO;
import com.tcc.tcc_project_management_backend.exception.ProjectNotFoundException;
import com.tcc.tcc_project_management_backend.exception.TaskNotFoundException;
import com.tcc.tcc_project_management_backend.model.Project;
import com.tcc.tcc_project_management_backend.model.Task;
import com.tcc.tcc_project_management_backend.repository.ProjectRepository;
import com.tcc.tcc_project_management_backend.repository.TaskRepository;
import com.tcc.tcc_project_management_backend.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, ProjectRepository projectRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskDTO createTask(Long projectId, CreateTaskDTO dto) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));

        Task task = taskMapper.toEntity(dto);
        task.setProject(project);

        Task saved = taskRepository.save(task);
        return taskMapper.toDTO(saved);
    }

    @Override
    public TaskDTO updateTask(Long id, UpdateTaskDTO dto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        taskMapper.updateEntity(task, dto);

        return taskMapper.toDTO(taskRepository.save(task));
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        return taskMapper.toDTO(task);
    }

    @Override
    public List<TaskDTO> getTasksByProject(Long projectId) {
        return taskRepository.findAll().stream()
                .filter(task -> task.getProject().getId().equals(projectId))
                .map(taskMapper::toDTO)
                .toList();
    }
}
