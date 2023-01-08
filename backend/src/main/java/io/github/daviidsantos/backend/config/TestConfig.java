package io.github.daviidsantos.backend.config;

import io.github.daviidsantos.backend.config.db.repository.ProjectSchemaRepository;
import io.github.daviidsantos.backend.config.db.repository.TicketSchemaRepository;
import io.github.daviidsantos.backend.config.db.repository.UserSchemaRepository;
import io.github.daviidsantos.backend.config.db.schema.ProjectSchema;
import io.github.daviidsantos.backend.config.db.schema.TicketSchema;
import io.github.daviidsantos.backend.config.db.schema.UserSchema;
import io.github.daviidsantos.backend.config.db.schema.enums.Priority;
import io.github.daviidsantos.backend.config.db.schema.enums.ProjectStatus;
import io.github.daviidsantos.backend.config.db.schema.enums.TicketStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDate;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    private final UserSchemaRepository userSchemaRepository;
    private final ProjectSchemaRepository projectSchemaRepository;
    private final TicketSchemaRepository ticketSchemaRepository;

    public TestConfig(UserSchemaRepository userSchemaRepository, ProjectSchemaRepository projectSchemaRepository, TicketSchemaRepository ticketSchemaRepository) {
        this.userSchemaRepository = userSchemaRepository;
        this.projectSchemaRepository = projectSchemaRepository;
        this.ticketSchemaRepository = ticketSchemaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        UserSchema user = new UserSchema(null, "David", "teste@teste.com", "123456", "Teste");
        userSchemaRepository.save(user);

        ProjectSchema project = new ProjectSchema(null, "Test", LocalDate.now(), LocalDate.now(), Priority.High, ProjectStatus.In_Progress);
        projectSchemaRepository.save(project);

        TicketSchema ticket = new TicketSchema(null, project, "Test", user, Instant.now(), null, TicketStatus.Unassigned, Priority.High);
        ticketSchemaRepository.save(ticket);
    }
}
