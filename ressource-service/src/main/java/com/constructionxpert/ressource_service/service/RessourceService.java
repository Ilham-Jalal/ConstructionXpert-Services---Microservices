package com.constructionxpert.ressource_service.service;

import com.constructionxpert.ressource_service.exception.ResourceNotFoundException;
import com.constructionxpert.ressource_service.model.Resource;
import com.constructionxpert.ressource_service.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RessourceService {

    private final ResourceRepository resourceRepository;
    private static final String projectServiceUrl = "http://tache-service/api/tasks/";

    public Resource createResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resource getResourceById(Long id) throws ResourceNotFoundException {
        return resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Resource updateResource(Long id, Resource resourceDetails) throws ResourceNotFoundException {
        Resource resource = resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        resource.setName(resourceDetails.getName());
        resource.setType(resourceDetails.getType());
        resource.setQuantity(resourceDetails.getQuantity());
        resource.setTaskId(resourceDetails.getTaskId());

        return resourceRepository.save(resource);
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }

    public List<Resource> getResourcesByTaskId(Long taskId) {
        return resourceRepository.findByTaskId(taskId);
    }
}
