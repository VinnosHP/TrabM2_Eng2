package configs;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
@ComponentScan(basePackages = { "controllers", "models", "observers", "repositories", "services", "web" })
public class DatabaseConfig {
    @Autowired
    private AppConfigs appConfigs;

    @Bean
    public MysqlConnection mysqlConnection() {
        MysqlConnection mysqlConnection = new MysqlConnection(appConfigs);
        mysqlConnection.connectDatabase();
        return mysqlConnection;
    }

    @Bean
    public DSLContext dslContext(MysqlConnection mysqlConnection) {
        Settings settings = new Settings()
                .withAttachRecords(false)
                .withExecuteLogging(true); // Supondo que o logging esteja habilitado

        Connection connection = mysqlConnection.getDbConnection();

        org.jooq.Configuration conf = new DefaultConfiguration()
                .set(SQLDialect.MYSQL)
                .set(connection)
                .set(settings);

        return DSL.using(conf);
    }
}
