package com.tcc.tcc_project_management_backend.repository;

import com.tcc.tcc_project_management_backend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
