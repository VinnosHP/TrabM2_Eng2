// package services.implementations;

// import java.util.ArrayList;
// import java.util.Calendar;

// public class Resposta {
// private Usuario usuario;
// private Pergunta pergunta;
// private String resposta;
// private ArrayList<Resposta> listaRespostas;
// private Calendar data;

// public Resposta(){
// this.usuario = null;
// this.pergunta = null;
// this.resposta = "";
// this.listaRespostas = null;
// this.data = null;
// }

// public Resposta(Usuario usuario, Pergunta pergunta, String resposta,
// ArrayList<Resposta> listaRespostas, Calendar data) {
// this.usuario = usuario;
// this.pergunta = pergunta;
// this.resposta = resposta;
// this.listaRespostas = listaRespostas;
// this.data = data;
// }

// public Usuario getUsuario() {
// return usuario;
// }

// public void setUsuario(Usuario usuario) {
// this.usuario = usuario;
// }

// public Pergunta getPergunta() {
// return pergunta;
// }

// public void setPergunta(Pergunta pergunta) {
// this.pergunta = pergunta;
// }

// public String getResposta() {
// return resposta;
// }

// public void setResposta(String resposta) {
// this.resposta = resposta;
// }

// public ArrayList<Resposta> getListaRespostas() {
// return listaRespostas;
// }

// public void setListaRespostas(ArrayList<Resposta> listaRespostas) {
// this.listaRespostas = listaRespostas;
// }

// public Calendar getData() {
// return data;
// }

// public void setData(Calendar data) {
// this.data = data;
// }

// public boolean respondePergunta(Usuario usuario, Pergunta pergunta, Calendar
// data, String resposta){
// try {
// setUsuario(usuario);
// setPergunta(pergunta);
// setData(data);
// setResposta(resposta);
// return true;
// } catch (Exception e) {
// System.out.println("Erro ao responder pergunta: " + e.getMessage());
// }
// return false;
// }

// public boolean respondeResposta(){
// return false;
// }
// }
