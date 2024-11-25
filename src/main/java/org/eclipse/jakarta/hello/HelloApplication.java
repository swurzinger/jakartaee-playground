package org.eclipse.jakarta.hello;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.ApplicationPath;
import org.flywaydb.core.Flyway;

import javax.sql.DataSource;

@ApplicationPath("rest")
public class HelloApplication extends Application {
  // Needed to enable Jakarta REST and specify path.
  @Resource(name = "jdbc/PostgresDS")
  private DataSource ds;

    @PostConstruct
    public void migrate() {
        var flyway = Flyway.configure()
                .dataSource(ds)
                .load();
        // flyway.baseline();
        flyway.migrate();
    }
}
