package com.constructionxpert.tache_service.repository;

import com.constructionxpert.tache_service.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task,Long> {
   List<Task> findByProjectId(Long id);
}
