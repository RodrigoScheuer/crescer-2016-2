console.log('Olá JS!');
console.log('Olá\'JS\'!');

console.log('Nome: ', elfo.nome);

elfo.flechas= 42;

console.log(elfo.flechas);

delete elfo.flechas;

console.log(elfo);

elfo['Nome Completo'] = 'Legolas da Silva';

console.log(elfo);

// public void atirarFlecha(Dwarf dwarf){ }
elfo.atirarFlecha = function(dwarf) {
  dwarf.vida -= 10;
  elfo.experiencia++;
}

var dwarf = {vida: 110};
elfo.atirarFlecha(dwarf);

console.log(elfo);

console.log(dwarf);

exibirElfoNaTela(elfo);
