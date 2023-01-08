package io.github.daviidsantos.backend.config.db.repository;

import io.github.daviidsantos.backend.config.db.schema.UserSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSchemaRepository extends JpaRepository<UserSchema, String> {
}
