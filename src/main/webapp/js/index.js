function validaLoginCampos(){
    if(document.getElementById("email").value == "" || document.getElementById("password").value == ""){
        window.alert("Preencha todos os campos!");
        return false;
    }
    return true;
}