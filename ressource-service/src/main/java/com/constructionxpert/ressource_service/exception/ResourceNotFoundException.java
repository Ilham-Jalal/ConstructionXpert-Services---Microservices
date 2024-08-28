package com.constructionxpert.ressource_service.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Long id) {
        super("Resource not found with id: " + id);
    }
}
