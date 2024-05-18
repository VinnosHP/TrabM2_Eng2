package services.implementations.User;
// package services.implementations;

// import db_mysql.Conexao_Mysql;

// public class Login {
// private Usuario usuario;

// public Login(){
// this.usuario = null;
// }

// public Login(Usuario usuario) {
// this.usuario = usuario;
// }

// public Usuario getUsuario() {
// return usuario;
// }

// public void setUsuario(Usuario usuario) {
// this.usuario = usuario;
// }
// public boolean verificaDados(Usuario usuario){
// Conexao_Mysql con = new Conexao_Mysql();
// con.openDatabase();
// String sqlQuery = "select email, senha from usuarios where email='" +
// usuario.getEmail() + "' and senha='"+usuario.getSenha()+"';";
// if(con.executaQuery(sqlQuery)) return true;
// else return false;
// }

// public boolean fazLogin(Usuario usuario){
// return verificaDados(usuario);
// }
// }
