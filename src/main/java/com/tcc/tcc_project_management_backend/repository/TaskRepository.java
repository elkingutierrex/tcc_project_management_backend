package com.tcc.tcc_project_management_backend.repository;

import com.tcc.tcc_project_management_backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
