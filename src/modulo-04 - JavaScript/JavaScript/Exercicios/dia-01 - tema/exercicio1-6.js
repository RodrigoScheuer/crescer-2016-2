  class Herois {

    constructor(array){
        this.heroi = array;
    }

    foraGuerraCivil(){
      let pacificos = [];
      let cont;
      let eventos = [];
      for(let i of this.heroi){
        eventos = i.events.items;
        cont = 0;
        for(let j of eventos){
          if(j.name === 'Civil War'){ cont++; }
        }
        if(cont === 0){
          pacificos.push(i);
        }
      }
      /*for (let i = 0, len = this.heroi.length; i < len; i++) {
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
      }*/
    return pacificos;
  }


  maisPublicado(){
    let personagem;
    let maior = 0;
    let heroi = this.heroi; // array marvel
    for(let i of heroi){
      if(i.comics.available > maior){
        maior = i.comics.available;
        personagem = i;
      }
    }
    /*for (let i = 1, len = this.heroi.length; i < len; i++) {
      if(this.heroi[i].comics.available > maior){
         maior = this.heroi[i].comics.available;
         personagem = this.heroi[i];
      }
    }*/
    return personagem;
  }

  mediaPaginas(){
    let media = 0;
    //let tamanhoQuadrinhos = 0;
    for (let i = 0, len = this.heroi.length; i < len; i++) {
      media += this.heroi[i].comics.items.reduce((acumulador, items) => acumulador + items.pageCount, 0);
       //tamanhoQuadrinhos = this.heroi[i].comics.items.length;
      /*for (let j = 0, len = tamanhoQuadrinhos ; j < len; j++) {
         media += this.heroi[i].comics.items[j].pageCount;
      }*/
    }
    return media/this.heroi.length;
  }

  seriesPorLongevidade(){
    let arraySeries = [];
    let tempoDuracao = 0;
    //let tamanhoSeries = 0;
    let Series = [];
    for (let i = 0, len = this.heroi.length; i < len; i++) {
       Series = this.heroi[i].series.items;
       for(let i of Series){
         tempoDuracao = i.endYear - i.startYear;
         arraySeries.push(tempoDuracao);
       }
       arraySeries.sort(function(a, b){return b-a});

      /* tamanhoSeries = this.heroi[i].series.items.length;
      for (let j = 0, len = tamanhoSeries ; j < len; j++) {
        tempoDuracao = (this.heroi[i].series.items[j].endYear) - (this.heroi[i].series.items[j].startYear);
        arraySeries.push(tempoDuracao);
        arraySeries.sort(function(a, b){return b-a});
      }*/
    }
    return arraySeries;
  }

  comicMaisCara(){
    let maior = 0;
    let soma = 0;
    let tamanhoQuadrinhos = 0;
    for (let i = 0, len = this.heroi.length; i < len; i++) {
      tamanhoQuadrinhos = this.heroi[i].comics.items.length;
      soma = 0;
      for (let j = 0, len = tamanhoQuadrinhos; j < len; j++) {
        //refactor
        soma += this.heroi[i].comics.items[j].prices.reduce((ac, prices) => ac + prices.price, 0);
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
