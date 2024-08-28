package com.constructionxpert.ressource_service.controller;

import com.constructionxpert.ressource_service.exception.ResourceNotFoundException;
import com.constructionxpert.ressource_service.model.Resource;
import com.constructionxpert.ressource_service.service.RessourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private RessourceService ressourceService;

    @PostMapping
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource) {
        Resource createdResource = ressourceService.createResource(resource);
        return ResponseEntity.ok(createdResource);
    }

    @GetMapping
    public ResponseEntity<List<Resource>> getAllResources() {
        return ResponseEntity.ok(ressourceService.getAllResources());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(ressourceService.getResourceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resource> updateResource(@PathVariable Long id, @RequestBody Resource resourceDetails) throws ResourceNotFoundException {
        return ResponseEntity.ok(ressourceService.updateResource(id, resourceDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable Long id) {
        ressourceService.deleteResource(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<Resource>> getResourcesByTaskId(@PathVariable Long taskId) {
        return ResponseEntity.ok(ressourceService.getResourcesByTaskId(taskId));
    }
}
