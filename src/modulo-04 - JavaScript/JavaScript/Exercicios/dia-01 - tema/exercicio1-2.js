  console.log("Array marvel");
  console.log(marvel);
  console.log("");

  class Herois {
    constructor(array){
        this.heroi = array;
  }

    foraGuerraCivil(){
      let pacificos = [];
      for (let i = 0, len = this.heroi.length; i < len; i++) {
        let eventos = this.heroi[i].events.items;
        let cont = 0;
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
    for (let i = 0, len = this.heroi.length; i < len; i++) {
      let tamanhoQuadrinhos = this.heroi[i].comics.items.length;
      for (let j = 0, len = tamanhoQuadrinhos ; j < len; j++) {
        media += this.heroi[i].comics.items[j].pageCount;
      }
    }
    return media/this.heroi.length;
  }

  seriesPorLongevidade(){
    let arraySeries = [];
    let tempoDuracao = 0;
    for (let i = 0, len = this.heroi.length; i < len; i++) {
      let tamanhoSeries = this.heroi[i].series.items.length;
      for (let j = 0, len = tamanhoSeries ; j < len; j++) {
        tempoDuracao = (this.heroi[i].series.items[j].endYear)  - (this.heroi[i].series.items[j].startYear);
        arraySeries.push(tempoDuracao);
        arraySeries.sort(function(a, b){return b-a});
      }
    }
    return arraySeries;
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
