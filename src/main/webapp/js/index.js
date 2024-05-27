function validaLoginCampos(){
    if(document.getElementById("email").value == "" || document.getElementById("password").value == ""){
        alert("Preencha todos os campos!");
        return false;
    }
    return true;
}