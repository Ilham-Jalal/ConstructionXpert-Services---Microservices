package com.constructionxpert.tache_service.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("La tâche avec l'ID " + id + " n'a pas été trouvée.");
    }
}
