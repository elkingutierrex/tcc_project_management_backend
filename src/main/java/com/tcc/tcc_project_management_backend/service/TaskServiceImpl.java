package com.tcc.tcc_project_management_backend.service.impl;

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

    public TaskServiceImpl(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public Task createTask(Long projectId, Task task) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        task.setProject(project);

        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task taskRequest) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setStatus(taskRequest.getStatus());
        task.setDueDate(taskRequest.getDueDate());

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }
        taskRepository.deleteById(id);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public List<Task> getTasksByProject(Long projectId) {
        return taskRepository.findAll()
                .stream()
                .filter(task -> task.getProject().getId().equals(projectId))
                .toList();
    }
}
