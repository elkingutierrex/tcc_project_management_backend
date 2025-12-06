package com.tcc.tcc_project_management_backend.service;

import com.tcc.tcc_project_management_backend.dto.CreateTaskDTO;
import com.tcc.tcc_project_management_backend.dto.TaskDTO;
import com.tcc.tcc_project_management_backend.dto.UpdateTaskDTO;

import java.util.List;

public interface TaskService {

    TaskDTO createTask(Long projectId, CreateTaskDTO dto);

    TaskDTO updateTask(Long id, UpdateTaskDTO dto);

    void deleteTask(Long id);

    TaskDTO getTaskById(Long id);

    List<TaskDTO> getTasksByProject(Long projectId);
}
