function redireciona(link){
    window.location.replace(link);
}

function validaEnvioResposta(){
    if(document.getElementById("textAreaResposta").value == ""){
        window.alert("Falha, pergunta vazia!");
        return false;
    }
    return true;
}