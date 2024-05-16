package db_mysql;

public class Inicializa_DB {
    public static void main(String[] args) {
        Conexao_Mysql conexao_Mysql = new Conexao_Mysql();
        String sql = "create table testeJava(id int primary key auto_increment, nome varchar(40), email varchar(40))";
        conexao_Mysql.openDatabase();
        conexao_Mysql.executaQuery(sql);
        
    }
}
