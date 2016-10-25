
console.log("-- Exercicio 1 --");
console.log(" ");
function gerarPiramide(niveis){


  for(var i = 0; i <= niveis; i++){
    var piramide = " ";
      for(var j= 0; j <= i; j++){
          piramide += 'R$';
      }
      console.log(piramide);
  }

}

gerarPiramide(5);

/*---------------------------------------------------------*/
console.log(" ");
console.log("-- Exercicio 2 --");
console.log(" ");
function diglettDig(){
  for(var i = 0; i <= 100; i++){
    if(i % 3 === 0){
      console.log('Diglett dig ' + i);
    }
    if(i% 5 === 0 && i%3 !== 0){
      console.log('trio trio trio ' + i);
    }
    if(i % 3 === 0 && i % 5 === 0){
      console.log('Diglett dig, trio trio trio ' + i);
    }
  }
}
console.log(" ");

diglettDig();

/*---------------------------------------------------------*/
console.log(" ");
console.log("-- Exercicio 3 --");
console.log(" ");


var maiorIgualADois = function(elemento) {
  return elemento >= 2;
};



function find(array, funcao) {
  if(typeof funcao === 'function'){
    var array2 = [];
    for(var i = 0, len = array.length; i < len; i++){
        if(funcao(array[i]) === true ){
          array2.push(array[i]);
        }
      }
    return array2;
  }else{
    return 0;
  }
}

console.log(find([ 1, 2, 3 ], maiorIgualADois));
// [ 2, 3 ]

console.log(find([ 'a', 5, null, false, 'false' ], function(elem) {
  return typeof elem === 'string';
}));
// [ 'a', 'false' ]

console.log(find([ { nome: 'a' }, { nome: 'b' }  ], function(elem) {
  return typeof elem.nome === 'c';
}));
// []

var notFunction = 'maior igual ou a dois';
// 0

describe('find(busca Maior Igual A Dois)', function() {
  it('[1,2,3] deve retornar 2,3', function() {
    var resultado = find([ 1, 2, 3 ], maiorIgualADois);
    expect(resultado).toEqual([2,3]);
  })});


  describe('find(encontra String Dentro do Array)', function() {
    it('[\'a\', 5, null, false, \'false\'] deve retornar \'a\',\'false\'', function() {
      var resultado = find(['a', 5, null, false, 'false'], function(elem) {
        return typeof elem === 'string';
      });
      expect(resultado).toEqual(['a','false']);
    })});

    describe('find(Buscar Nome \'c\')', function() {
      it('[{ nome: \'a\' }, { nome: \'b\' }] deve retornar []', function() {
        var resultado = find([{ nome: 'a' }, { nome: 'b' }], function(elem) {
          return typeof elem.nome === 'c';
        });
        expect(resultado).toEqual([]);
      })});

      describe('find(Segundo parametro não é função)', function() {
        it('[1,2,3] deve retornar 0', function() {
          var resultado = find([ 1, 2, 3 ], notFunction);
          expect(resultado).toEqual(0);
        })});

/*---------------------------------------------------------*/
/*console.log(" ");
console.log("-- Exercicio 4 --");
console.log(" ");
//  não consigui fazer

function subtrair(num1)(num2) {
    return num1 - num2;
}

console.log(subtrair(2)(1)); // 1
console.log(subtrair(0)(0)); // 0
console.log(subtrair(-1)(2)); // -3 */


/*---------------------------------------------------------*/
console.log(" ");
console.log("-- Exercicio 5 --");
console.log(" ");


function iguais(par1, par2){
  if(typeof par1 === 'object' && typeof par2 === 'object'){
    if(par1 === par2){
      return true;
    }else{
      return false;
      // fazer comparação de objetos aki
      }
  }
}

console.log(" ");

var obj = { a: { a: 'a' }, b: 2 };
console.log(iguais(obj, obj)); // true
console.log(iguais(obj, { a: 1, b: 2 })); // false
console.log(iguais(obj, { a: { a: 'a' }, b: 2 })); // true
console.log(iguais({ a: 1 }, { b: 1 })); // false

console.log("-----------------------------------------------------");

var goku = {
  nivel: 'SSJ4',
  golpes: [ { nome: 'kamehameha', dano: 45 }, { nome: 'genki-dama', dano: 99 } ],
  nome: 'Goku',
}, sonGoku = {
  nome: 'Goku',
  nivel: 'SSJ4',
  golpes: [ { nome: 'kamehameha', dano: 45 }, { nome: 'genki-dama', dano: 99 } ]
};
console.log(iguais(goku, sonGoku)); // true
console.log(iguais({ a: 1 }, { a: 1, b: 2 })); // false
