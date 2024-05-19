function validaLoginCampos(){
    if(document.getElementById("email").value == "" || document.getElementById("password").value == ""){
        window.alert("Preencha todos os campos!");
        return false;
    }
    return true;
}

function validaCadastroCampos(){
    if(document.getElementById("name").value == "" || document.getElementById("email").value == "" || document.getElementById("password").value == ""){
        window.alert("Preencha todos os campos!");
        return false;
    }
    return true;
}

function validaCriaCampos(){
    if (document.getElementById("textAreaFormulario").value == "") {
        window.alert("Pergunta em branco!");
        return false;
    }
    return true;
}

function redireciona(link){
    window.location.replace(link);
}