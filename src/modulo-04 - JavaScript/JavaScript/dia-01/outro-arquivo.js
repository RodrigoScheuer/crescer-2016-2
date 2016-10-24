
var elfo = {nome: 'Legolas', experiencia: 1};

function exibirElfoNaTela(elfo) {

  function maiusculo(texto){
    return texto.toUpperCase();
  }

  alert(maiusculo(elfo.nome));

}
