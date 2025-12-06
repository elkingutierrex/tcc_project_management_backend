package com.tcc.tcc_project_management_backend.service;

import com.tcc.tcc_project_management_backend.model.Task;
import java.util.List;

public interface TaskService {

    Task createTask(Long projectId, Task task);

    Task updateTask(Long id, Task task);

    void deleteTask(Long id);

    Task getTaskById(Long id);

    List<Task> getTasksByProject(Long projectId);
}
