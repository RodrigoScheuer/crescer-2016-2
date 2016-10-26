describe('foraGuerraCivil()', function() {
  it('[8] deve retornar 1 personagem', function() {
    let personagem = new Herois([{name: "Guardians of the Galaxy", eventos: "Civil War"}, {name:"Capitao caverna", eventos:"Caverna"}]);
    var resultado = personagem.foraGuerraCivil();
    expect(resultado).toEqual([Object]);
  });

  it('retorna alguma coisa', function(){
  let dadosHerois = [
  { name: 'Debug Destruidor', comics: { available: 12 } },
  { name: 'Tipagem Maravilhosa', comics: { available: 39 } },
  { name: 'Compilador Prateado', comics: { available: 3 } }
]
let herois = new Herois(dadosHerois);
expect(herois.maisPublicado()).toEqual({ name: 'Tipagem Maravilhosa', comics: { available: 39 } });
  });
});
