CREATE TABLE ressource (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         type VARCHAR(255) NOT NULL,
                         quantity INTEGER,
                         tache_id BIGINT NOT NULL
);
