package io.github.daviidsantos.backend.config.db.schema;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.daviidsantos.backend.config.db.schema.enums.Priority;
import io.github.daviidsantos.backend.config.db.schema.enums.TicketStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_tickets")
public class TicketSchema implements Serializable {
    private static final Long serialVersionUUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "id_project")
    private ProjectSchema project;

    @Column(nullable = false)
    private String title;
    @ManyToOne
    @JoinColumn(name = "id_issuer")
    private UserSchema issuer;
    @Column(nullable = false)
    private Instant issuedAt;
    @ManyToOne
    @JoinColumn(name = "id_developer")
    private UserSchema assignedDeveloper;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatus status;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;

    public TicketSchema() {
    }

    public TicketSchema(UUID id, ProjectSchema project, String title, UserSchema issuer, Instant issuedAt, UserSchema assignedDeveloper, TicketStatus status, Priority priority) {
        this.id = id;
        this.project = project;
        this.title = title;
        this.issuer = issuer;
        this.issuedAt = issuedAt;
        this.assignedDeveloper = assignedDeveloper;
        this.status = status;
        this.priority = priority;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ProjectSchema getProject() {
        return project;
    }

    public void setProject(ProjectSchema project) {
        this.project = project;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserSchema getIssuer() {
        return issuer;
    }

    public void setIssuer(UserSchema issuer) {
        this.issuer = issuer;
    }

    public Instant getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Instant issuedAt) {
        this.issuedAt = issuedAt;
    }

    public UserSchema getAssignedDeveloper() {
        return assignedDeveloper;
    }

    public void setAssignedDeveloper(UserSchema assignedDeveloper) {
        this.assignedDeveloper = assignedDeveloper;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketSchema that = (TicketSchema) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

