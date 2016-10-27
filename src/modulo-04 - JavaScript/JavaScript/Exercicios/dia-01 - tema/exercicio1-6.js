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
    return this.heroi
    .sort((heroi1, heroi2) => heroi2.comics.available - heroi1.comics.available)[0];
  }

  mediaPaginas(){
    //pagecount
    return this.heroi.reduce((acumulador, heroi) => acumulador +
    heroi.comics.items.reduce((ac, comic) => ac + comic.pageCount,0),0) / this.heroi.length;
  }

  seriesPorLongevidade(){
    let todasSeries = this.heroi
    .map(heroi => heroi.series.items)
    .reduce(
    (ac, series) => ac.concat(series), []);

    let diff = serie => serie.endYear - serie.startYear;

    return todasSeries
    .sort((serie1, serie2) => diff(serie2) - diff(serie1));
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
