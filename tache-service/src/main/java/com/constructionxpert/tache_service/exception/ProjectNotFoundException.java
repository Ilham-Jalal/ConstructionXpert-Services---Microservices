package com.constructionxpert.tache_service.exception;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(Long id) {
        super("Le projet avec l'ID " + id + " n'a pas été trouvé.");
    }
}
