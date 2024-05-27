function redireciona(link){
  window.location.href = link;
}

function mostraTabela(tabelaId) {
    document.getElementById(tabelaId).style.display = "block";
    const outrasTabelas = Array.from(
      document.getElementsByClassName("tabela")
    );
    outrasTabelas.forEach((tabela) => {
      if (tabela.id !== tabelaId) {
        tabela.style.display = "none";
      }
    });
  }

  function escondeTabela(tabelaId) {
    document.getElementById(tabelaId).style.display = "none";
  }

