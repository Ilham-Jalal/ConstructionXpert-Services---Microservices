package com.constructionxpert.project_service.repository;


import com.constructionxpert.project_service.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
