<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="css/login.css" />
    <script src="js/index.js"></script>
    <script>
      function validaLoginCampos() {
        if (document.getElementById("email").value == "" || document.getElementById("password").value == "") {
          window.alert("Preencha todos os campos!");
          return false;
        }
        return true;
      }
    </script>
  </head>
  <body>
    <input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
    <div class="page" name="div_principal">
      <form method="post" class="formLogin" action="login" onsubmit="return validaLoginCampos()">
        <h1>Login</h1>
        <p>Digite os seus dados de acesso no campo abaixo.</p>
        <div id="divCaixaEmail">
          <input id="email" name="userEmail" type="email" placeholder="Digite o seu email" autofocus="true" required/> <!-- Alteração aqui: name="userEmail" -->
        </div>
        <div id="divCaixaPassword">
          <input id="password" name="userPassword" type="password" placeholder="Digite a sua senha" required/> <!-- Alteração aqui: name="userPassword" -->
        </div>
        <div id="divLogin">
          <button type="submit">Entrar</button> <!-- Remoção do evento onclick -->
        </div>
        <div id="divEsqueciSenha">
          <a href="/">Esqueceu a senha ?</a>
        </div>
        <div id="divCadastrar">
          <p>Não possui cadastro ?</p>
          <a href="/cadastro">Cadastrar</a>
        </div>
      </form>
    </div>
    <script type="text/javascript">
      var status = document.getElementById("status").value;
      if(status == "failed"){
        swal("Sorry", "Wrong Email or Password", "error")
      }
    </script>
  </body>
</html>