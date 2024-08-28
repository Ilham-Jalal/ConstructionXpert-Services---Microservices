package com.constructionxpert.ressource_service.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private int quantity;

    @Column(name = "tache_id", nullable = false)
    private Long taskId;
}
