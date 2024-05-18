package app.configs;

import lombok.Getter;
import org.springframework.stereotype.Component;
import io.github.cdimascio.dotenv.Dotenv;

@Getter
@Component
public class AppConfigs {
    Dotenv dotenv = Dotenv.load();

    private final String DBUserName;
    private final String DBPassword;
    private final String DBDataBase;
    private final String DBHost;
    private final String DBPort;
    private final String DBDialect;
    private final String DBURL;

    public AppConfigs() {
        this.DBUserName = dotenv.get("DB_USERNAME");
        if (DBUserName == null) {
            throw new IllegalArgumentException("DB_USERNAME is not provided");
        }

        this.DBPassword = dotenv.get("DB_PASSWORD");
        if (DBPassword == null) {
            throw new IllegalArgumentException("DB_PASSWORD is not provided");
        }

        this.DBDataBase = dotenv.get("DB_DATABASE");
        if (DBDataBase == null) {
            throw new IllegalArgumentException("DB_DATABASE is not provided");
        }

        this.DBHost = dotenv.get("DB_HOST");
        if (DBHost == null) {
            throw new IllegalArgumentException("DB_HOST is not provided");
        }

        this.DBPort = dotenv.get("DB_PORT");
        if (DBPort == null) {
            throw new IllegalArgumentException("DB_PORT is not provided");
        }

        this.DBDialect = dotenv.get("DB_DIALECT");
        if (DBDialect == null) {
            throw new IllegalArgumentException("DB_DIALECT is not provided");
        }

        this.DBURL = dotenv.get("DB_URL");
        if (DBURL == null) {
            throw new IllegalArgumentException("DB_URL is not provided");
        }
    }
}
