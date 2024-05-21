function redireciona(link){
    window.location.replace(link);
}

function validaCriaPergunta(){
    if(document.getElementById("textAreaFormulario").value == ""){
        window.alert("Falha, pergunta vazia!");
        return false;
    }
    return true;
}