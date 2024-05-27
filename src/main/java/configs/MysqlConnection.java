package configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class MysqlConnection {

    @Autowired
    private AppConfigs appConfigs;

    private Connection dbConnection = null;
    private Statement sqlManager = null;

    public MysqlConnection(AppConfigs appConfigs) { // passa a instÂncia de appconfigs p construtor
        this.appConfigs = appConfigs; // garante que mysqlcoonection vai ter acesso aos valores corretor das configs
                                      // necessarias
    }

    public void connectDatabase() {
        try {
            dbConnection = DriverManager.getConnection(appConfigs.getDBURL(), appConfigs.getDBUserName(),
                    appConfigs.getDBPassword());

            System.out.println("Conectado com sucesso");

            sqlManager = dbConnection.createStatement();
        } catch (SQLException e) {
            System.out.println("Error on connect: " + e.getMessage()); // mudar mensagem de erro aqui
        }
    }

    public void disconnectDatabase() {
        try {
            if (sqlManager != null) {
                sqlManager.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
                System.out.println("Desconectado com sucesso");
            }
        } catch (SQLException e) {
            System.out.println("Error on close: " + e.getMessage());
        }
    }

    public Connection getDbConnection() {
        return dbConnection;
    }
}