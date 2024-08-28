package com.constructionxpert.project_service.controller;

import com.constructionxpert.project_service.exception.ProjectNotFoundException;
import com.constructionxpert.project_service.model.Project;
import com.constructionxpert.project_service.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project projectDetails) throws ProjectNotFoundException, ProjectNotFoundException {
        return projectService.updateProject(id, projectDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/exist")
    public ResponseEntity<Boolean> existProject(@PathVariable("id") Long id) {
        boolean exist = projectService.existProject(id);
        return ResponseEntity.ok(exist);
    }
}
