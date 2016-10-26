  console.log("Array marvel");
  console.log(marvel);
  console.log("");

  class Herois {
    constructor(array){
        this.heroi = array;
  }

    foraGuerraCivil(){
      let pacificos = [];
      let cont = 0;
      let eventos = [];
      for (let i = 0, len = this.heroi.length; i < len; i++) {
        eventos = this.heroi[i].events.items;
        cont = 0;
        for (let j = 0, len = eventos.length; j < len; j++) {
          if(eventos[j].name === 'Civil War'){
              cont++;
          }
        }
        if(cont === 0){
        pacificos.push(this.heroi[i]);
        }
      }
    return pacificos;
  }


  maisPublicado(){
    let personagem;
    let maior = this.heroi[0].comics.available;
    for (let i = 1, len = this.heroi.length; i < len; i++) {
      if(this.heroi[i].comics.available > maior){
         maior = this.heroi[i].comics.available;
         personagem = this.heroi[i];
      }
    }
    return personagem;
  }

  mediaPaginas(){
    let media = 0;
    let tamanhoQuadrinhos = 0;
    for (let i = 0, len = this.heroi.length; i < len; i++) {
       tamanhoQuadrinhos = this.heroi[i].comics.items.length;
      for (let j = 0, len = tamanhoQuadrinhos ; j < len; j++) {
         media += this.heroi[i].comics.items[j].pageCount;
      }
    }
    return media/this.heroi.length;
  }

  seriesPorLongevidade(){
    let arraySeries = [];
    let tempoDuracao = 0;
    let tamanhoSeries = 0;
    for (let i = 0, len = this.heroi.length; i < len; i++) {
       tamanhoSeries = this.heroi[i].series.items.length;
      for (let j = 0, len = tamanhoSeries ; j < len; j++) {
        tempoDuracao = (this.heroi[i].series.items[j].endYear)  - (this.heroi[i].series.items[j].startYear);
        arraySeries.push(tempoDuracao);
        arraySeries.sort(function(a, b){return b-a});
      }
    }
    return arraySeries;
  }

  comicMaisCara(){
    let maior = 0;
    let soma = 0;
    let tamanhoQuadrinhos = 0;
    let tamanhoPrices = 0;
    for (let i = 0, len = this.heroi.length; i < len; i++) {
      tamanhoQuadrinhos = this.heroi[i].comics.items.length;
      soma = 0;
      for (let j = 0, len = tamanhoQuadrinhos; j < len; j++) {
          tamanhoPrices = this.heroi[i].comics.items[j].prices.length;
        for (let l = 0, len = tamanhoPrices; l < len; l++) {
            soma += this.heroi[i].comics.items[j].prices[l].price;
        }
      }
      if(soma > maior){
        maior = soma;
      }
    }
    return maior;
  }


}

let personagem = new Herois(marvel);

console.log("personagem fora do Guerra Civil");
console.log(personagem.foraGuerraCivil());
console.log("");
console.log("personagem com mais historias em quadrinhos");
console.log(personagem.maisPublicado());
console.log("");
console.log("Média de paginas");
console.log(personagem.mediaPaginas());
console.log("");
console.log("Series mais longas");
console.log(personagem.seriesPorLongevidade());
console.log("");
console.log("Comic mais Cara");
console.log(personagem.comicMaisCara());
