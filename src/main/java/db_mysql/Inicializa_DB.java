package db_mysql;

import java.sql.SQLException;

class Inicializa_DB {
    public static void criaBancoDeDados(Conexao_Mysql con) throws SQLException{
        try {
            String sqlQuery = "create database if not exists trabm2_eng2;";
            con.openDatabase();
            con.executaQuery(sqlQuery);
            con.closeDatabase();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
 
    public static void criaTabela(Conexao_Mysql con) throws SQLException{
        try {
            String sqlQuery = "create table if not exists usuarios(id int primary key auto_increment, nome varchar(40), email varchar(40), senha varchar(40));";
            con.openDatabase();
            con.executaQuery(sqlQuery);
            con.closeDatabase();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void iniciaAlgunsUsuarios(Conexao_Mysql con) throws SQLException{
        try {
            String sqlQuery = "insert into testUser(nome, email, senha) " +
                              "values ('Osvaldo Gomes', 'ghostOG@gmail.com', 'ghostOG123')," +
                                     "('Jurema Santos', 'ghostJS@gmail.com', 'ghostJS123');";
            con.openDatabase();
            con.executaQuery(sqlQuery);
            con.closeDatabase();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void selectTable(Conexao_Mysql con) throws SQLException{
        try {
            String sqlQuery = "select * from testUser;";
            con.openDatabase();
            con.executaQuery(sqlQuery);
            con.closeDatabase();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Conexao_Mysql conexao_Mysql = new Conexao_Mysql();
        
    }
}
