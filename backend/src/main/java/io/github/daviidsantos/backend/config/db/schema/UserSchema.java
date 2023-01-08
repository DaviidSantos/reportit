package io.github.daviidsantos.backend.config.db.schema;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_user")
public class UserSchema implements Serializable {
    private static final Long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;
    @ManyToMany(mappedBy = "team")
    private Set<ProjectSchema> projects = new HashSet<>();

    @OneToMany(mappedBy = "issuer")
    private Set<TicketSchema> issuedTickets = new HashSet<>();

    @OneToMany(mappedBy = "assignedDeveloper")
    private Set<TicketSchema> assignedTickets = new HashSet<>();

    public UserSchema() {
    }

    public UserSchema(UUID id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<ProjectSchema> getProjects() {
        return projects;
    }

    public Set<TicketSchema> getIssuedTickets() {
        return issuedTickets;
    }

    public Set<TicketSchema> getAssignedTickets() {
        return assignedTickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSchema that = (UserSchema) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
