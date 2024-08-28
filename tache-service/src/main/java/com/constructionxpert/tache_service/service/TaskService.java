package com.constructionxpert.tache_service.service;

import com.constructionxpert.tache_service.exception.ProjectNotFoundException;
import com.constructionxpert.tache_service.exception.TaskNotFoundException;
import com.constructionxpert.tache_service.model.Task;
import com.constructionxpert.tache_service.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final RestTemplate restTemplate;
    private  final TaskRepository taskRepository;

    private static final String projectServiceUrl = "http://project-service/api/projects/";

    public Task createTask(Task task) {
        validateProjectExists(task.getProjectId());
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) throws TaskNotFoundException {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task updateTask(Long id, Task taskDetails) throws TaskNotFoundException {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        validateProjectExists(taskDetails.getProjectId());

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        task.setDueDate(taskDetails.getDueDate());
        task.setProjectId(taskDetails.getProjectId());

        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByProjectId(Long projectId) {
        validateProjectExists(projectId);
        return taskRepository.findByProjectId(projectId);
    }

    private void validateProjectExists(Long projectId) {
        if (projectId == null) {
            throw new IllegalArgumentException("Project ID cannot be null");
        }
        String url = projectServiceUrl + projectId + "/exist";
        Boolean exists = restTemplate.getForObject(url, Boolean.class);
        if (exists == null || !exists) {
            throw new ProjectNotFoundException(projectId);
        }
    }


    public Boolean existTask(Long id) {
        return taskRepository.findById(id).isPresent();
    }
}
