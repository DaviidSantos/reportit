package io.github.daviidsantos.backend.config.db.repository;

import io.github.daviidsantos.backend.config.db.schema.ProjectSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectSchemaRepository extends JpaRepository<ProjectSchema, UUID> {
}
