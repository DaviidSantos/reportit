package io.github.daviidsantos.backend.config.db.repository;

import io.github.daviidsantos.backend.config.db.schema.TicketSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketSchemaRepository extends JpaRepository<TicketSchema, UUID> {
}
