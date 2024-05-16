package db_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao_Mysql {
    public static String URL = "jdbc:mysql://localhost:3306/trabm2_eng2";
    public static String USER = "ademiro";
    public static String PWD = "PipipiPopopo";

    private Connection dbConnection = null;
    private Statement sqlManager = null;

    public void openDatabase(){
        try {
            dbConnection = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Conectado com sucesso em: " + URL);
            sqlManager = dbConnection.createStatement();
        } catch (Exception e) {
            System.out.println("Error on connect: " + e.getMessage());
        }
    }

    public void closeDatabase() throws SQLException{
        sqlManager.close();
        dbConnection.close();
    }

    public boolean executaQuery(String sql){
        try {
            return sqlManager.execute(sql);
        } catch (Exception e) {
            System.out.println("Error on connect: " + e.getMessage());
        }
        return false;
    }
}
