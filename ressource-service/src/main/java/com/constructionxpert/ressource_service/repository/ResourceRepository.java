package com.constructionxpert.ressource_service.repository;

import com.constructionxpert.ressource_service.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository <Resource,Long>{
    List<Resource> findByTaskId(Long id);
}
