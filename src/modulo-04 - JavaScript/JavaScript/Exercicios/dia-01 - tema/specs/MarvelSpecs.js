
  describe('maisPublicado()', function() {
  it('retorna personagens com mais quadrinhos publicados', function(){
  let dadosHerois = [
  { name: 'Debug Destruidor', comics: { available: 12 } },
  { name: 'Tipagem Maravilhosa', comics: { available: 39 } },
  { name: 'Compilador Prateado', comics: { available: 3 } }
  ]

let herois = new Herois(dadosHerois);
expect(herois.maisPublicado()).toEqual({ name: 'Tipagem Maravilhosa', comics: { available: 39 } });
  });


  /*it('retorna personagens que não participou do guerra civil', function(){
  let dadosHerois = [
  { name: 'Debug Destruidor', events: { [{name: 'Guerra Civil'},
                                         {name: 'Warcraft'}
                                         {name: 'Civil War'}] } },
  { name: 'Tipagem Maravilhosa', events: { [{name: 'Guerra Civil'},
                                            {name: 'Warcraft'}
                                            {name: 'Civilization War'}] } },
  { name: 'Compilador Prateado', events: { [{name: 'Guerra Civil'},
                                            {name: 'Warcraft'}
                                            {name: 'Civil Warming'}] } }
  ]

let herois2 = new Herois(dadosHerois);
expect(herois2.foraGuerraCivil()).toEqual( { name: 'Debug Destruidor',
                                            events: { [{name: 'Guerra Civil'},
                                                       {name: 'Warcraft'}
                                                       {name: 'Civil War'}] });
  });*/
});
