package services.implementations.User;
// package services.implementations;

// import db_mysql.Conexao_Mysql;

// public class Cadastro {
// private Usuario usuario;

// public Cadastro(){
// this.usuario = null;
// }

// public Cadastro(Usuario usuario) {
// this.usuario = usuario;
// }

// public Usuario getUsuario() {
// return usuario;
// }

// public void setUsuario(Usuario usuario) {
// this.usuario = usuario;
// }

// public boolean verificaDadosExistentes(Usuario usuario){
// Conexao_Mysql con = new Conexao_Mysql();
// con.openDatabase();
// String sqlQuery = "select email, senha, nome from usuarios where email='" +
// usuario.getEmail()
// + "' and senha='" + usuario.getSenha() + "' and nome='" + usuario.getNome()
// +"';";
// if(con.executaQuery(sqlQuery)) return true;
// else return false;
// }

// public boolean fazCadastro(String nome, String email, String senha){
// if (verificaDadosExistentes(usuario)) {
// return false;
// }
// usuario.setNome(nome);
// usuario.setEmail(email);
// usuario.setSenha(senha);
// return true;
// }
// }
