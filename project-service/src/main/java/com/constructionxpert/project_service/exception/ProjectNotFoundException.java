package com.constructionxpert.project_service.exception;

public class ProjectNotFoundException extends Exception{
    public ProjectNotFoundException(long id) {
        super("Project with" + id + " not found");
    }
}
